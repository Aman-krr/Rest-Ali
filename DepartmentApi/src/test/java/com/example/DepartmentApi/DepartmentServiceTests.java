package com.example.DepartmentApi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.DepartmentApi.dao.DepartmentDao;
import com.example.DepartmentApi.entity.Department;
import com.example.DepartmentApi.service.DepartmentService;

@SpringBootTest
//@ExtendWith(SpringExtension.class)
class DepartmentServiceApplicationTests{
 @Autowired
	 DepartmentService service ;
 @MockBean
	 DepartmentDao dao;
	
	 @BeforeEach
	void  setUp() {
		Department dept = Department.builder().deprtmentId(1).departmentName("IT").departmentAddress("My Computer").departmentCode("J-101").build();
	    Mockito.when(dao.findBydepartmentName("IT")).thenReturn(dept);
	 }
	 
	@Test
	@DisplayName("Test FinByName")
	 void  TestFindByDeptName() {
		 String deptName="IT";
		 Department dept1 = dao.findBydepartmentName(deptName);
		 System.out.println(dept1.getDepartmentName()+"Test");
		 Assertions.assertEquals(deptName, dept1.getDepartmentName());
	
	 }
}