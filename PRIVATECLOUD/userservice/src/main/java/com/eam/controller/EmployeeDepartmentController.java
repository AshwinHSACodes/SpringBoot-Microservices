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

import com.eam.entity.Emp_Dept;
import com.eam.service.EmpDeptService;

@RestController
@RequestMapping("empDept")
public class EmployeeDepartmentController {
	
	@Autowired
	EmpDeptService empDeptService;
	
	Logger logger = LoggerFactory.getLogger(EmployeeDepartmentController.class);
	
	@GetMapping("/hello")
	public String sayHelloMethod() {

        // Logging various log level messages 
        logger.trace("Log level: TRACE"); 
        logger.info("Log level: INFO"); 
        logger.debug("Log level: DEBUG"); 
        logger.error("Log level: ERROR"); 
        logger.warn("Log level: WARN"); 
		
		return "Hello from employeedepartment controller service";
	}
	
	@PostMapping("saveEmpDept")
	public Emp_Dept saveEmpDept(@RequestBody Emp_Dept emp_Dept) {
		return empDeptService.saveEmpDept(emp_Dept.getEmpId(), emp_Dept.getDeptId());
	}
	
	@GetMapping("getAllEmpDeptMapping")
	public List<Emp_Dept> getAllEmpDeptMapping(){
		return empDeptService.getAllEmpDeptMapping();
	}

}
