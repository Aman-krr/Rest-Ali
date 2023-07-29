package com.example.DepartmentApi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.DepartmentApi.dao.DepartmentDao;
import com.example.DepartmentApi.entity.Department;

@DataJpaTest
 class daoLayerTests {

	@Autowired
	DepartmentDao dao;
	@Autowired
	private TestEntityManager entitymanager;
	
	@BeforeEach
	void setUp() {
		Department dept = Department.builder().departmentName("Elec").departmentAddress("North").departmentCode("101").build();
		   entitymanager.persist(dept);
	}
	
	@Test
	 void TestSave() {
		Department dept1 = dao.findById(1).get();
		Assertions.assertEquals("Elec",dept1.getDepartmentName());
		
	}
}
