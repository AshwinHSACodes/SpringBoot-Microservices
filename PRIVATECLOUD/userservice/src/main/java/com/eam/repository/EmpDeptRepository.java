package com.eam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eam.entity.Emp_Dept;

@Repository
public interface EmpDeptRepository extends JpaRepository<Emp_Dept, Emp_Dept>{

}
