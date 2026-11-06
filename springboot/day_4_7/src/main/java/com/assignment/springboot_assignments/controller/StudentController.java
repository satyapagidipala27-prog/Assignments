package com.assignment.springboot_assignments.controller;

import com.assignment.springboot_assignments.dto.StudentRequestDTO;
import com.assignment.springboot_assignments.dto.StudentResponseDTO;
import com.assignment.springboot_assignments.entity.Student;
import com.assignment.springboot_assignments.service.StudentService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.time.LocalDate;

import com.assignment.springboot_assignments.entity.StudentStatus;


@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<StudentResponseDTO> createStudent(
            @Valid @RequestBody StudentRequestDTO requestDTO) {

        Student student = studentService.toEntity(requestDTO);

        Student savedStudent = studentService.saveStudent(student);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentService.toResponseDTO(savedStudent));
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> getAllStudents() {

        List<StudentResponseDTO> students =
                studentService.getAllStudents()
                        .stream()
                        .map(studentService::toResponseDTO)
                        .toList();

        return ResponseEntity.ok(students);
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> getStudentById(
            @PathVariable Long id) {

        Student student = studentService.getStudentById(id);

        return ResponseEntity.ok(
                studentService.toResponseDTO(student)
        );
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody StudentRequestDTO requestDTO) {

        Student updatedStudent = studentService.toEntity(requestDTO);

        Student savedStudent =
                studentService.updateStudent(id, updatedStudent);

        return ResponseEntity.ok(
                studentService.toResponseDTO(savedStudent)
        );
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(
            @PathVariable Long id) {

        studentService.deleteStudent(id);

        return ResponseEntity.noContent().build();
    }
    @GetMapping("/search")
    public ResponseEntity<List<StudentResponseDTO>> searchStudents(
            @RequestParam String name) {

        List<StudentResponseDTO> students =
                studentService.searchByName(name)
                        .stream()
                        .map(studentService::toResponseDTO)
                        .toList();

        return ResponseEntity.ok(students);
    }
    @GetMapping("/search/status")
    public ResponseEntity<List<StudentResponseDTO>> searchByStatus(
            @RequestParam StudentStatus status) {

        List<StudentResponseDTO> students =
                studentService.searchByStatus(status)
                        .stream()
                        .map(studentService::toResponseDTO)
                        .toList();

        return ResponseEntity.ok(students);
    }
    @GetMapping("/jpql/search")
    public ResponseEntity<List<StudentResponseDTO>> searchByNameJPQL(
            @RequestParam String name) {

        List<StudentResponseDTO> students =
                studentService.searchByNameJPQL(name)
                        .stream()
                        .map(studentService::toResponseDTO)
                        .toList();

        return ResponseEntity.ok(students);
    }

    @GetMapping("/jpql/status")
    public ResponseEntity<List<StudentResponseDTO>> searchByStatusJPQL(
            @RequestParam StudentStatus status) {

        List<StudentResponseDTO> students =
                studentService.searchByStatusJPQL(status)
                        .stream()
                        .map(studentService::toResponseDTO)
                        .toList();

        return ResponseEntity.ok(students);
    }

    @GetMapping("/jpql/date-range")
    public ResponseEntity<List<StudentResponseDTO>> searchByDateRange(
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {

        List<StudentResponseDTO> students =
                studentService.searchByDateRange(startDate, endDate)
                        .stream()
                        .map(studentService::toResponseDTO)
                        .toList();

        return ResponseEntity.ok(students);
    }
}