package com.assignment.springboot_assignments.dto;

import java.util.List;

public class DepartmentRequestDTO {

    private String name;
    private List<EmployeeRequestDTO> employees;

    public DepartmentRequestDTO() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EmployeeRequestDTO> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeRequestDTO> employees) {
        this.employees = employees;
    }
}