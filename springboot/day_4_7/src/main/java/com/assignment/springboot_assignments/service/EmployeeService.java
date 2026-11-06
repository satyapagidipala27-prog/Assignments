package com.assignment.springboot_assignments.service;

import com.assignment.springboot_assignments.entity.Employee;
import com.assignment.springboot_assignments.repository.EmployeeRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional(readOnly = true)
    public String testLazyLoading(Long id) {

        // Step 1: Retrieve Employee
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Employee not found"));

        System.out.println("Employee name: " + employee.getName());

        // Step 2: Access Department
        System.out.println("Accessing Department now...");

        System.out.println(
                "Department: " + employee.getDepartment().getName()
        );

        return "Lazy loading test completed";
    }
    @Transactional(readOnly = true)
    public String testJoinFetch() {

        List<Employee> employees =
                employeeRepository.findAllWithDepartment();

        for (Employee employee : employees) {
            System.out.println(
                    employee.getName() + " - " +
                            employee.getDepartment().getName()
            );
        }

        return "JOIN FETCH test completed";
    }
    @Transactional(readOnly = true)
    public String testEntityGraph() {

        List<Employee> employees =
                employeeRepository.findAllWithEntityGraph();

        for (Employee employee : employees) {
            System.out.println(
                    employee.getName() + " - " +
                            employee.getDepartment().getName()
            );
        }

        return "EntityGraph test completed";
    }
}