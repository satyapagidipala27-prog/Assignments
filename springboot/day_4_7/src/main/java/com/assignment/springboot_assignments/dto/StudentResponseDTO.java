package com.assignment.springboot_assignments.dto;
import com.assignment.springboot_assignments.entity.StudentStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;


public class StudentResponseDTO {
    private Long id;
    private String name;
    private String email;
    private LocalDate dateOfBirth;
    private StudentStatus status;

    public StudentResponseDTO() {

    }
    public StudentResponseDTO(Long id, String name, String email, LocalDate dateOfBirth, StudentStatus status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.status = status;

    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @JsonFormat(pattern = "dd-MM-yyyy")

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public StudentStatus getStatus() {
        return status;
    }
    public void setStatus(StudentStatus status) {
        this.status = status;
    }



}
