package com.assignment.springboot_assignments.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.EntityGraph;

import com.assignment.springboot_assignments.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {

    @EntityGraph(attributePaths = {"department"})
    @Query("SELECT e FROM Employee e")
    List<Employee> findAllWithEntityGraph();

    @Query("SELECT e FROM Employee e WHERE e.id = :id")
    Optional<Employee> findEmployeeForFetchTest(@Param("id") Long id);

    @Query("""
    SELECT e
    FROM Employee e
    JOIN FETCH e.department
    """)
    List<Employee> findAllWithDepartment();
}
