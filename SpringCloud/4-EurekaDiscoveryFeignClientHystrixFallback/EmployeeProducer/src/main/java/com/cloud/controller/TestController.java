package com.cloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.domain.Employee;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class TestController {

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "getDataFallBack")
	public Employee firstPage() {

		Employee emp = new Employee();
		emp.setName("emp1");
		emp.setDesignation("manager");
		emp.setEmpId("1");
		emp.setSalary(3000);

		int x = 10/0;
		
		return emp;
	}

	public Employee getDataFallBack() {

		Employee emp = new Employee();
		emp.setName("fallback-emp1");
		emp.setDesignation("fallback-manager");
		emp.setEmpId("fallback-1");
		emp.setSalary(3000);

		return emp;

	}
}
