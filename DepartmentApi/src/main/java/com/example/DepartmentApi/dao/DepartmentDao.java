package com.example.DepartmentApi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.DepartmentApi.entity.Department;

@Repository
public interface DepartmentDao extends JpaRepository<Department, Integer> {
	
	public Department findBydepartmentName(String name);

	public Department findBydepartmentNameIgnoreCase(String name);

	@Query(value = "select DEPARTMENT_CODE from Department  where DEPARTMENT_NAME =?1", nativeQuery = true)
	public String getDeptCode(String value);
}
