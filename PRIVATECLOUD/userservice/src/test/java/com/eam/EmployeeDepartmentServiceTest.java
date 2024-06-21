package com.eam;

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

import com.eam.entity.Emp_Dept;
import com.eam.repository.EmpDeptRepository;
import com.eam.service.EmpDeptService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeDepartmentServiceTest {

	@Autowired
	EmpDeptService empDeptService;
	
	@MockBean
	EmpDeptRepository empDeptRepository;
	
	@Test
	public void test_saveEmpDept() {
		
//		Emp_Dept emp_Dept = new Emp_Dept(5L, 5L, 5L);
//		
//		when(empDeptRepository.save(emp_Dept)).thenReturn(emp_Dept);
//		
//		assertEquals(emp_Dept, empDeptService.saveEmpDept(5L, 5L));
		
	}
	
}
