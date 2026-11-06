package com.assignment.springboot_assignments.dto;

import com.assignment.springboot_assignments.entity.StudentStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class StudentRequestDTO {
    @NotBlank(message = "Name is required")
    @Size(min = 3, message = "Name must contain at least 3 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Please provide a valid email address")
    private String email;

    @NotNull(message = "Date of birth is required")
    @Past(message = "Date of birth must be in the past")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;

    @NotNull(message = "Student status is required")
    private StudentStatus status;



    public StudentRequestDTO() {

    }
    public StudentRequestDTO(String name, String email, LocalDate dateOfBirth, StudentStatus status) {
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.status = status;

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
