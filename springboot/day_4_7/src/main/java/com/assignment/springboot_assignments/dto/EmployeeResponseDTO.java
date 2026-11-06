package com.assignment.springboot_assignments.dto;

public class EmployeeResponseDTO {

    private Long id;
    private String name;
    private String email;

    public EmployeeResponseDTO() {}

    public EmployeeResponseDTO(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}