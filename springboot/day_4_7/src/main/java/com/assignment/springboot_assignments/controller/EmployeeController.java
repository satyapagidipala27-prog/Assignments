package com.assignment.springboot_assignments.controller;

import com.assignment.springboot_assignments.service.EmployeeService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}/lazy-test")
    public ResponseEntity<String> testLazyLoading(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                employeeService.testLazyLoading(id)
        );
    }
    @GetMapping("/join-fetch-test")
    public ResponseEntity<String> testJoinFetch() {

        return ResponseEntity.ok(
                employeeService.testJoinFetch()
        );
    }
    @GetMapping("/entity-graph-test")
    public ResponseEntity<String> testEntityGraph() {

        return ResponseEntity.ok(
                employeeService.testEntityGraph()
        );
    }
}