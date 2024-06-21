package com.eam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eam.entity.Employee;
import com.eam.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public Employee getEmployeeById(Long id) {
		return employeeRepository.getById(id);
	}

	public List<Employee> getAllemployees() {
		return employeeRepository.findAll();
	}

	public Employee getEmployeeByEmail(String emailid) {
		return employeeRepository.findByEmailid(emailid);
	}
}

