package com.example.DepartmentApi;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.DepartmentApi.entity.Department;

@SpringBootTest
class DepartmentApiApplicationTests {

	@BeforeEach
	void  setUp() {
		 System.out.println("Tet");
		Department dept = Department.builder().deprtmentId(1).departmentName("Java").departmentAddress("My Computer").departmentCode("J-101").build();
	 
	 }
	
	@Test
	@DisplayName("Check Service")
	void contextLoads() {
		System.out.println("TEST");
	}

}
