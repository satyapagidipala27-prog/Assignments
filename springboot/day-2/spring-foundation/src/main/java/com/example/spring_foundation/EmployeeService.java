package com.example.spring_foundation;

import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final List<Employee> employees = new CopyOnWriteArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(Objects.requireNonNull(employee, "employee must not be null"));
    }

    public List<Employee> getEmployees() {
        return List.copyOf(employees);
    }
}
