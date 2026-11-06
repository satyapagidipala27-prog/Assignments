package com.assignment.springboot_assignments.repository;

import com.assignment.springboot_assignments.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    // Find courses by exact name
    List<Course> findByName(String name);

    // Find courses by status
    List<Course> findByStatus(String status);

    // Find courses containing a keyword
    List<Course> findByNameContainingIgnoreCase(String name);

    // Find courses by fee less than a given amount
    List<Course> findByFeeLessThan(Double fee);

    // Find courses starting after a given date
    List<Course> findByStartDateAfter(java.time.LocalDate date);
    // Search courses by name using JPQL
    @Query("SELECT c FROM Course c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Course> searchByNameJPQL(@Param("name") String name);


    // Search courses by status
    @Query("SELECT c FROM Course c WHERE c.status = :status")
    List<Course> searchByStatusJPQL(@Param("status") String status);


    // Search courses within a fee range
    @Query("SELECT c FROM Course c WHERE c.fee BETWEEN :minFee AND :maxFee")
    List<Course> findByFeeRange(
            @Param("minFee") Double minFee,
            @Param("maxFee") Double maxFee
    );


    // Search courses by start-date range
    @Query("SELECT c FROM Course c WHERE c.startDate BETWEEN :startDate AND :endDate")
    List<Course> findByStartDateRange(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );
}