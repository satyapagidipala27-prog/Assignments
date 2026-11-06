package com.assignment.springboot_assignments.service;

import com.assignment.springboot_assignments.dto.EnrollmentRequestDTO;
import com.assignment.springboot_assignments.entity.Student;
import com.assignment.springboot_assignments.entity.Course;
import com.assignment.springboot_assignments.repository.StudentRepository;
import com.assignment.springboot_assignments.repository.CourseRepository;
import com.assignment.springboot_assignments.exception.DuplicateEnrollmentException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnrollmentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public EnrollmentService(
            StudentRepository studentRepository,
            CourseRepository courseRepository) {

        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Transactional
    public String enrollStudent(EnrollmentRequestDTO request) {

        // 1. Find the existing Student
        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() ->
                        new RuntimeException("Student not found"));

        // 2. Find the existing Course
        Course course = courseRepository.findById(request.getCourseId())
                .orElseThrow(() ->
                        new RuntimeException("Course not found"));

        // 3. Prevent duplicate enrollment
        if (student.getCourses().contains(course)) {
            throw new DuplicateEnrollmentException(
                    "Student is already enrolled in this course");
        }

        // 4. Establish the Many-to-Many relationship
        student.enrollInCourse(course);

        // 5. Save the owning side
        studentRepository.save(student);

        return "Student enrolled successfully";
    }
}