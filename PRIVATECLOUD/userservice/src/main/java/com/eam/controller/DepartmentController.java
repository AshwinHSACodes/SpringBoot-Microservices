package com.eam.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eam.entity.Department;
import com.eam.service.DepartmentService;

@RestController
@RequestMapping("department")
public class DepartmentController {
	
	Logger logger = LoggerFactory.getLogger(DepartmentController.class);

	@Autowired
	DepartmentService departmentService;
	
	@GetMapping("/hello")
	public String sayHelloMethod() {

        // Logging various log level messages 
        logger.trace("Log level: TRACE"); 
        logger.info("Log level: INFO"); 
        logger.debug("Log level: DEBUG"); 
        logger.error("Log level: ERROR"); 
        logger.warn("Log level: WARN"); 
		
		return "Hello from department controller service";
	}
	
	@PostMapping("saveDepartment")
	public Department saveDepartment(@RequestBody Department department) {
		logger.info("Department : " + department);
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("listAllDepartments")
	public List<Department> getAllDepartments(){
		logger.info("getAllDepartments() method called");
		return departmentService.getAllDepartments();
	}
}
