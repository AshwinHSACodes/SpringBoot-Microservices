package com.eam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eam.entity.Department;
import com.eam.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;
	
	public Department addDepartment(Department department) {
		return departmentRepository.save(department);
	}
	
	public List<Department> getAllDepartments(){
		return departmentRepository.findAll();
	}
}
