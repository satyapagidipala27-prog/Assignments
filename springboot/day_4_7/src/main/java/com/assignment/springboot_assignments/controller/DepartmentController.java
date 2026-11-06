package com.assignment.springboot_assignments.controller;

import com.assignment.springboot_assignments.dto.DepartmentRequestDTO;
import com.assignment.springboot_assignments.dto.DepartmentResponseDTO;
import com.assignment.springboot_assignments.service.DepartmentService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<DepartmentResponseDTO> createDepartment(
            @RequestBody DepartmentRequestDTO request) {

        DepartmentResponseDTO response =
                departmentService.createDepartment(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}