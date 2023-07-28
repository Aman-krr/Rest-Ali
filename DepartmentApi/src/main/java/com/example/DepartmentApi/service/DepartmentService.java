package com.example.DepartmentApi.service;

import java.util.List;

import com.example.DepartmentApi.Exception.DepartmentNotFoundException;
import com.example.DepartmentApi.entity.Department;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> getDepartments();

	public Department getDepartmentById(Integer id) throws DepartmentNotFoundException;

	public String deleteDepartment(Integer id);

	public Department updateDepartment(Integer id, Department dept);

	public Department getDeptByName(String name);

	public String getGenericValue(String value);

}
