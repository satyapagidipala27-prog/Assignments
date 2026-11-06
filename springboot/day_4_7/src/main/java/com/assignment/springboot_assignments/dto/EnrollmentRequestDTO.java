package com.assignment.springboot_assignments.dto;

public class EnrollmentRequestDTO {

    private Long studentId;
    private Long courseId;

    public EnrollmentRequestDTO() {}

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}