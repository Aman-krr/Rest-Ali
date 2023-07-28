package com.example.DepartmentApi.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckServiceController {
	@GetMapping(value = "/")
	public String checkService() {
     return "Service is Up and Working !!";
	}
}
