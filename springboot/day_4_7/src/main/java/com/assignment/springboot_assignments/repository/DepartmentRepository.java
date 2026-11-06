package com.assignment.springboot_assignments.repository;

import com.assignment.springboot_assignments.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository
        extends JpaRepository<Department, Long> {
}