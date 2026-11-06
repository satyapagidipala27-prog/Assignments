package com.assignment.springboot_assignments.service;

import com.assignment.springboot_assignments.dto.StudentRequestDTO;
import com.assignment.springboot_assignments.dto.StudentResponseDTO;
import com.assignment.springboot_assignments.entity.Student;
import com.assignment.springboot_assignments.exception.DuplicateStudentException;
import com.assignment.springboot_assignments.exception.StudentNotFoundException;
import com.assignment.springboot_assignments.repository.StudentRepository;
import com.assignment.springboot_assignments.entity.StudentStatus;
import java.time.LocalDate;
import com.assignment.springboot_assignments.entity.StudentStatus;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    // Constructor Injection
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student toEntity(StudentRequestDTO requestDTO) {
        Student student = new Student();

        student.setName(requestDTO.getName());
        student.setEmail(requestDTO.getEmail());
        student.setDateOfBirth(requestDTO.getDateOfBirth());
        student.setStatus(requestDTO.getStatus());

        return student;
    }

    public StudentResponseDTO toResponseDTO(Student student) {
        return new StudentResponseDTO(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getDateOfBirth(),
                student.getStatus()
        );
    }

    // Save student into database
    public Student saveStudent(Student student) {

        boolean emailExists =
                studentRepository.existsByEmailIgnoreCase(student.getEmail());

        if (emailExists) {
            throw new DuplicateStudentException(
                    "A student with this email already exists"
            );
        }

        return studentRepository.save(student);
    }

    // Get first available student
    public Student getStudent() {

        List<Student> students = studentRepository.findAll();

        return students.isEmpty() ? null : students.get(0);
    }

    // Get student using ID
    public Student getStudentById(Long id) {

        return studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException(
                                "Student not found with ID: " + id
                        )
                );
    }

    // Retrieve all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Update student
    public Student updateStudent(Long id, Student updatedStudent) {

        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(
                        "Student not found with ID: " + id
                ));

        boolean emailExists =
                studentRepository.existsByEmailIgnoreCaseAndIdNot(
                        updatedStudent.getEmail(), id
                );

        if (emailExists) {
            throw new DuplicateStudentException(
                    "A student with this email already exists"
            );
        }

        existingStudent.setName(updatedStudent.getName());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setDateOfBirth(updatedStudent.getDateOfBirth());
        existingStudent.setStatus(updatedStudent.getStatus());

        return studentRepository.save(existingStudent);
    }

    // Delete student
    public void deleteStudent(Long id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(
                        "Student not found with ID: " + id
                ));

        studentRepository.delete(student);
    }
    public List<Student> searchByName(String name) {
        return studentRepository.findByNameContainingIgnoreCase(name);
    }
    public List<Student> searchByStatus(StudentStatus status) {
        return studentRepository.findByStatus(status);
    }
    public List<Student> searchByNameJPQL(String name) {
        return studentRepository.searchByNameJPQL(name);
    }

    public List<Student> searchByStatusJPQL(StudentStatus status) {
        return studentRepository.searchByStatusJPQL(status);
    }

    public List<Student> searchByDateRange(
            LocalDate startDate, LocalDate endDate) {

        return studentRepository.findStudentsByDateRange(
                startDate, endDate
        );
    }
}