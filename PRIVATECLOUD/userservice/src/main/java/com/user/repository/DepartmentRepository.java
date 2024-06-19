package com.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
