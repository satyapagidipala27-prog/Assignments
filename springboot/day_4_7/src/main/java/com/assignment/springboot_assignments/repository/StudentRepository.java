package com.assignment.springboot_assignments.repository;

import com.assignment.springboot_assignments.entity.Student;
import com.assignment.springboot_assignments.entity.StudentStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    boolean existsByEmailIgnoreCase(String email);

    boolean existsByEmailIgnoreCaseAndIdNot(String email, Long id);

    // Find by exact name
    List<Student> findByName(String name);

    // Find by status
    List<Student> findByStatus(StudentStatus status);

    // Find names containing the given text
    List<Student> findByNameContainingIgnoreCase(String name);

    // Find by email
    Student findByEmail(String email);
    // Search students by name using JPQL
    @Query("SELECT s FROM Student s WHERE LOWER(s.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Student> searchByNameJPQL(@Param("name") String name);


    // Search students by status using JPQL
    @Query("SELECT s FROM Student s WHERE s.status = :status")
    List<Student> searchByStatusJPQL(@Param("status") StudentStatus status);


    // Search students by date of birth range
    @Query("SELECT s FROM Student s WHERE s.dateOfBirth BETWEEN :startDate AND :endDate")
    List<Student> findStudentsByDateRange(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );


}