package com.eam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eam.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
