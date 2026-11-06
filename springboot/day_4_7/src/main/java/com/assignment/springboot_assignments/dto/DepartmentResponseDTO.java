package com.assignment.springboot_assignments.dto;

import java.util.List;

public class DepartmentResponseDTO {

    private Long id;
    private String name;
    private List<EmployeeResponseDTO> employees;

    public DepartmentResponseDTO() {}

    public DepartmentResponseDTO(Long id, String name,
                                 List<EmployeeResponseDTO> employees) {
        this.id = id;
        this.name = name;
        this.employees = employees;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<EmployeeResponseDTO> getEmployees() {
        return employees;
    }
}