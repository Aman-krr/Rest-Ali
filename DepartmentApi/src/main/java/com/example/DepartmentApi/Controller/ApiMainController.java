package com.example.DepartmentApi.Controller;

import java.util.List;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.DepartmentApi.Exception.DepartmentNotFoundException;
import com.example.DepartmentApi.entity.Department;
import com.example.DepartmentApi.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
public class ApiMainController {
	
	 public  Logger logger = org.slf4j.LoggerFactory.getLogger(ApiMainController.class);
	@Autowired
	private DepartmentService service;

	@PostMapping("/Createdepartment")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		logger.info("Createing Department");
		return service.saveDepartment(department);

	}
	@GetMapping("/getDepartments")
	public List<Department> getDepartments() {
		return service.getDepartments();
	}
	@GetMapping("/getDepartment/{id}")
	//using path Variable
	public Department getDeptById(@PathVariable Integer id) throws DepartmentNotFoundException {
		return service.getDepartmentById(id);
	}
	@DeleteMapping("/deleteDepartment/{id}")
	public String deleteDepartment( @PathVariable Integer id) {
		 service.deleteDepartment(id);
		 return "Success";
	}
	@PutMapping("/Updatedepartment/{id}") 
	public Department updateDepartmet(@PathVariable Integer id,@RequestBody Department dept){
		return service.updateDepartment(id, dept);
		
	}
	@GetMapping("/department/name/{name}")
	public Department getDeptByName( @PathVariable String name) {
		return service.getDeptByName(name);
	}
	@GetMapping("/department/generic/{value}") 
	public String getValue(@PathVariable String value) {
		return service.getGenericValue(value);
	}
}
