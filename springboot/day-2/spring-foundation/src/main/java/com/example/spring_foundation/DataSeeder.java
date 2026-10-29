package com.example.spring_foundation;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.ApplicationContext;

@Component
public class DataSeeder implements ApplicationRunner {

    private final EmployeeService employeeService;
    private final ApplicationContext context;

    public DataSeeder(
            EmployeeService employeeService,
            ApplicationContext context) {
        this.employeeService = employeeService;
        this.context = context;
    }

    @Override
    public void run(ApplicationArguments args) {

        System.out.println(
                "ObjectMapper beans: "
                        + context.getBeansOfType(ObjectMapper.class).keySet()
        );

        employeeService.addEmployee(new Employee(1, "Satya"));
        employeeService.addEmployee(new Employee(2, "Rahul"));
        employeeService.addEmployee(new Employee(3, "Priya"));

        System.out.println("Employees added successfully!");

        for (Employee employee : employeeService.getEmployees()) {
            System.out.println(employee);
        }
    }
}
