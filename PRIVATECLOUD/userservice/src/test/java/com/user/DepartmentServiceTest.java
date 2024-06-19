package com.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.user.entity.Department;
import com.user.repository.DepartmentRepository;
import com.user.service.DepartmentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentServiceTest {
	
	@Autowired
	DepartmentService departmentService;
	
	@MockBean
	DepartmentRepository departmentRepository;
	
	@Test
	public void test_addDepartment() {
		Department department = new Department(1L, "ADMIN");
		when(departmentRepository.save(department)).thenReturn(department);
		
		assertEquals(department, departmentService.addDepartment(department));
	}
	
	@Test
	public void test_getAllDepartments() {
		List<Department> listOfDepartments = new ArrayList();
		
		Department department1 = new Department(1L, "department10");
		Department department2 = new Department(1L, "department100");
		Department department3 = new Department(1L, "department1000");
		Department department4 = new Department(1L, "department100000");
		Department department5 = new Department(1L, "department1000000");
		
		listOfDepartments.add(department1);
		listOfDepartments.add(department2);
		listOfDepartments.add(department3);
		listOfDepartments.add(department4);
		listOfDepartments.add(department5);

		when(departmentService.getAllDepartments()).thenReturn(listOfDepartments);
		
		assertEquals(5, departmentService.getAllDepartments().size());
	}

}

//This is dummy text to check git checkin from sts.