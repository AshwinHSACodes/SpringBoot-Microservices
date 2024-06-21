package com.eam;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.eam.entity.Employee;
import com.eam.repository.EmployeeRepository;
import com.eam.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeServiceTests {

	@Autowired
	EmployeeService employeeService;

	@MockBean
	EmployeeRepository employeeRepository;

	@Test
	void contextLoads() {
	}

	@SuppressWarnings("removal")
	@Test
	public void test_addUser() {
		Employee employee = new Employee(new Long(1), "Ashwin1", "Kumar1", "ashwin1@gmail.com", "Bengaluru", "1234567890",
				"ashwin1", "ashwin1");
		when(employeeService.saveEmployee(employee)).thenReturn(employee);
		assertEquals(employee, employeeService.saveEmployee(employee));
	}

	@Test
	public void test_getUserById() {
		Employee employee = new Employee(new Long(1), "Ashwin1", "Kumar1", "ashwin1@gmail.com", "Bengaluru", "1234567890",
				"ashwin1", "ashwin1");
		when(employeeRepository.getById(new Long(1))).thenReturn(employee);
		assertEquals(employee, employeeService.getEmployeeById(new Long(1)));
	}

	@Test
	public void test_getUserByEmail() {
		Employee user = new Employee(new Long(1), "Ashwin1", "Kumar1", "ashwin1@gmail.com", "Bengaluru", "1234567890",
				"ashwin1", "ashwin1");
		when(employeeService.getEmployeeByEmail("ashwin1@gmail.com")).thenReturn(user);
		assertEquals(user, employeeService.getEmployeeByEmail("ashwin1@gmail.com"));
	}

}
