package com.assignment.springboot_assignments.service;

import com.assignment.springboot_assignments.entity.Course;
import com.assignment.springboot_assignments.repository.CourseRepository;
import com.assignment.springboot_assignments.repository.StudentRepository;
import com.assignment.springboot_assignments.entity.Student;


import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Course not found with ID: " + id));
    }

    public Course updateCourse(Long id, Course updatedCourse) {

        Course existingCourse = getCourseById(id);

        existingCourse.setName(updatedCourse.getName());
        existingCourse.setDescription(updatedCourse.getDescription());
        existingCourse.setDurationWeeks(updatedCourse.getDurationWeeks());
        existingCourse.setFee(updatedCourse.getFee());
        existingCourse.setStatus(updatedCourse.getStatus());
        existingCourse.setStartDate(updatedCourse.getStartDate());

        return courseRepository.save(existingCourse);
    }

    public void deleteCourse(Long id) {
        Course course = getCourseById(id);
        courseRepository.delete(course);
    }
    public List<Course> searchByName(String name) {
        return courseRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Course> searchByStatus(String status) {
        return courseRepository.findByStatus(status);
    }

    public List<Course> searchByFeeLessThan(Double fee) {
        return courseRepository.findByFeeLessThan(fee);
    }
    public List<Course> searchByNameJPQL(String name) {
        return courseRepository.searchByNameJPQL(name);
    }

    public List<Course> searchByStatusJPQL(String status) {
        return courseRepository.searchByStatusJPQL(status);
    }

    public List<Course> searchByFeeRange(Double minFee, Double maxFee) {
        return courseRepository.findByFeeRange(minFee, maxFee);
    }

    public List<Course> searchByStartDateRange(
            LocalDate startDate, LocalDate endDate) {

        return courseRepository.findByStartDateRange(startDate, endDate);
    }
}