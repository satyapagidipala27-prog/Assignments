package com.assignment.springboot_assignments.service;

import com.assignment.springboot_assignments.dto.DepartmentRequestDTO;
import com.assignment.springboot_assignments.dto.EmployeeRequestDTO;
import com.assignment.springboot_assignments.entity.Department;
import com.assignment.springboot_assignments.entity.Employee;
import com.assignment.springboot_assignments.repository.DepartmentRepository;
import com.assignment.springboot_assignments.dto.DepartmentResponseDTO;
import com.assignment.springboot_assignments.dto.EmployeeResponseDTO;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public DepartmentResponseDTO createDepartment(DepartmentRequestDTO request) {

        // 1. Create Department entity
        Department department = new Department();
        department.setName(request.getName());

        // 2. Convert each employee DTO into an Employee entity
        if (request.getEmployees() != null) {
            for (EmployeeRequestDTO employeeDTO : request.getEmployees()) {

                Employee employee = new Employee();
                employee.setName(employeeDTO.getName());
                employee.setEmail(employeeDTO.getEmail());

                // 3. Establish the relationship on both sides
                department.addEmployee(employee);
            }
        }

        // 4. Save the department
        // CascadeType.ALL also saves its employees
        Department savedDepartment = departmentRepository.save(department);

        return toResponseDTO(savedDepartment);
    }
    private DepartmentResponseDTO toResponseDTO(Department department) {

        List<EmployeeResponseDTO> employees =
                department.getEmployees()
                        .stream()
                        .map(employee -> new EmployeeResponseDTO(
                                employee.getId(),
                                employee.getName(),
                                employee.getEmail()
                        ))
                        .toList();

        return new DepartmentResponseDTO(
                department.getId(),
                department.getName(),
                employees
        );
    }
}