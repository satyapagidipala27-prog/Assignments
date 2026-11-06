package com.assignment.springboot_assignments.controller;

import com.assignment.springboot_assignments.entity.Course;
import com.assignment.springboot_assignments.service.CourseService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;


import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<Course> createCourse(
            @RequestBody Course course) {

        Course savedCourse = courseService.createCourse(course);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedCourse);
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(
            @PathVariable Long id) {

        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(
            @PathVariable Long id,
            @RequestBody Course course) {

        return ResponseEntity.ok(
                courseService.updateCourse(id, course));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(
            @PathVariable Long id) {

        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/search")
    public ResponseEntity<List<Course>> searchCourses(
            @RequestParam String name) {

        return ResponseEntity.ok(
                courseService.searchByName(name)
        );
    }

    @GetMapping("/search/status")
    public ResponseEntity<List<Course>> searchByStatus(
            @RequestParam String status) {

        return ResponseEntity.ok(
                courseService.searchByStatus(status)
        );
    }

    @GetMapping("/search/fee")
    public ResponseEntity<List<Course>> searchByFee(
            @RequestParam Double maxFee) {

        return ResponseEntity.ok(
                courseService.searchByFeeLessThan(maxFee)
        );
    }
    @GetMapping("/jpql/search")
    public ResponseEntity<List<Course>> searchByNameJPQL(
            @RequestParam String name) {

        return ResponseEntity.ok(
                courseService.searchByNameJPQL(name)
        );
    }

    @GetMapping("/jpql/status")
    public ResponseEntity<List<Course>> searchByStatusJPQL(
            @RequestParam String status) {

        return ResponseEntity.ok(
                courseService.searchByStatusJPQL(status)
        );
    }

    @GetMapping("/jpql/fee-range")
    public ResponseEntity<List<Course>> searchByFeeRange(
            @RequestParam Double minFee,
            @RequestParam Double maxFee) {

        return ResponseEntity.ok(
                courseService.searchByFeeRange(minFee, maxFee)
        );
    }

    @GetMapping("/jpql/date-range")
    public ResponseEntity<List<Course>> searchByStartDateRange(
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {

        return ResponseEntity.ok(
                courseService.searchByStartDateRange(startDate, endDate)
        );
    }

}