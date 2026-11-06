package com.assignment.springboot_assignments.controller;

import com.assignment.springboot_assignments.dto.EnrollmentRequestDTO;
import com.assignment.springboot_assignments.service.EnrollmentService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping
    public ResponseEntity<String> enrollStudent(
            @RequestBody EnrollmentRequestDTO request) {

        String response = enrollmentService.enrollStudent(request);

        return ResponseEntity.ok(response);
    }
}