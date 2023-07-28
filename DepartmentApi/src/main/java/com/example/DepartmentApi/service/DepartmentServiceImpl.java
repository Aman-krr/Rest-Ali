package com.example.DepartmentApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DepartmentApi.Exception.DepartmentNotFoundException;
import com.example.DepartmentApi.dao.DepartmentDao;
import com.example.DepartmentApi.entity.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
	public DepartmentDao dao;
	@Override
	public Department saveDepartment(Department department) {
		
		return dao.save(department);
	}
	@Override
	public List<Department> getDepartments() {
		return dao.findAll();
	}
	@Override
	public Department getDepartmentById(Integer id) throws DepartmentNotFoundException {
	
		if(!dao.findById(id).isPresent()) {
			throw new DepartmentNotFoundException ("Department Not found ");
		}
		return dao.findById(id).get();//as it returns optional
	}
	@Override
	public String deleteDepartment(Integer id) {
		dao.deleteById(id);
		return "Success";
	}
	@Override
	public Department updateDepartment( Integer id,Department dept) {
		Department deptOld= dao.findById(id).isPresent()?dao.findById(id).get():null;
		
		dept.setDeprtmentId(deptOld.getDeprtmentId());
		if(dept != null && !"".equals(dept.getDepartmentName()) && dept.getDepartmentName() != null) {
			deptOld.setDepartmentName(dept.getDepartmentName());
		}
		if(dept != null && !"".equals(dept.getDepartmentAddress()) && dept.getDepartmentAddress() != null) {
			deptOld.setDepartmentAddress(dept.getDepartmentAddress());
		}
		if(dept != null && !"".equals(dept.getDepartmentCode()) && dept.getDepartmentCode() != null) {
			deptOld.setDepartmentCode(dept.getDepartmentCode());
		}
		
			return dao.save(deptOld);
	}
	@Override
	public Department getDeptByName(String name) {
		return dao.findBydepartmentNameIgnoreCase(name);
	}
	@Override
	public String getGenericValue(String value) {
		return dao.getDeptCode(value);
	}


}
