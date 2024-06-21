package com.eam.controller;

import java.util.List;

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
	
	@PostMapping("saveEmpDept")
	public Emp_Dept saveEmpDept(@RequestBody Emp_Dept emp_Dept) {
		return empDeptService.saveEmpDept(emp_Dept.getEmpId(), emp_Dept.getDeptId());
	}
	
	@GetMapping("getAllEmpDeptMapping")
	public List<Emp_Dept> getAllEmpDeptMapping(){
		return empDeptService.getAllEmpDeptMapping();
	}

}
