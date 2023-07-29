package com.example.DepartmentApi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.DepartmentApi.Controller.ApiMainController;
import com.example.DepartmentApi.entity.Department;
import com.example.DepartmentApi.service.DepartmentService;

@WebMvcTest(ApiMainController.class)
public class ControllerTests {
	@Autowired
	private MockMvc mockmvc;
	@MockBean
	private DepartmentService service;

	private Department dept;
	@BeforeEach
	void setUp() {
      dept = Department.builder().deprtmentId(101).departmentName("HI-TECH").departmentAddress("City").departmentCode("121").build();
	}
	@Test
	void TestCotrollerSave() throws Exception {
		Department dept1=Department.builder().departmentName("HI-TECH").departmentAddress("City").departmentCode("121").build();
		Mockito.when(service.saveDepartment(dept1)).thenReturn(dept);
		mockmvc.perform(MockMvcRequestBuilders.post("/Createdepartment").contentType(MediaType.APPLICATION_JSON).content("{\r\n"
				+ "\"departmentName\":\"ECEEEEEEEEEEEEE\",\r\n"
				+ "\"departmentAddress\":\"NORTH Block, ELECTRICAL DEPARTMENT\",\r\n"
				+ "\"departmentCode\":\"221\"\r\n"
				+ "\r\n"
				+ "}")).andExpect(MockMvcResultMatchers.status().isOk());
	}
}
