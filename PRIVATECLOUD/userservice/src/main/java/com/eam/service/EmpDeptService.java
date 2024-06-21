package com.eam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eam.entity.Emp_Dept;
import com.eam.repository.EmpDeptRepository;

@Service
public class EmpDeptService {

	@Autowired
	EmpDeptRepository empDeptRepository;
	
	public Emp_Dept saveEmpDept(Long empId, Long deptId) {
		Emp_Dept emp_Dept = new Emp_Dept();
		emp_Dept.setEmpId(empId);
		emp_Dept.setDeptId(deptId);
		return empDeptRepository.save(emp_Dept);
	}

	public List<Emp_Dept> getAllEmpDeptMapping() {
		return empDeptRepository.findAll();
	}
}
