package com.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.Department;
import com.user.service.DepartmentService;

@RestController
@RequestMapping("department")
public class DepartmentController {
	
	Logger logger = LoggerFactory.getLogger(DepartmentController.class);

	@Autowired
	DepartmentService departmentService;
	
	@PostMapping("addDepartment")
	public Department addDepartment(@RequestBody Department department) {
		logger.info("Department : " + department);
		return departmentService.addDepartment(department);
	}
	
	@GetMapping("listAllDepartments")
	public List<Department> getAllDepartments(){
		logger.info("getAllDepartments() method called");
		return departmentService.getAllDepartments();
	}
}
