package com.eam.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eam.entity.Employee;
import com.eam.service.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController {

	Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/hello")
	public String sayHelloMethod() {

        // Logging various log level messages 
        logger.trace("Log level: TRACE"); 
        logger.info("Log level: INFO"); 
        logger.debug("Log level: DEBUG"); 
        logger.error("Log level: ERROR"); 
        logger.warn("Log level: WARN"); 
		
		return "Hello from user service";
	}
	
	@PostMapping("saveEmployee")
	public Employee addEmployee(@RequestBody Employee employee) {
		logger.info("user : " + employee);
		return employeeService.saveEmployee(employee);
	}
	
	@GetMapping(value = "/getEmployeeById/{id}")
	public Employee getEmployeeById(@PathVariable("id") Long id) {
		logger.info("id : " +id);
		return employeeService.getEmployeeById(id);
	}
	
	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees(){
		logger.info(" getAllEmployees called");
		return employeeService.getAllemployees();
	}
	
	@GetMapping("/getEmployeeByEmail/{emailid}")
	public Employee getEmployeeByEmail(@PathVariable(value = "emailid") String emailid) {
		logger.info("emailid : " + emailid);
		return employeeService.getEmployeeByEmail(emailid);
	}
}
