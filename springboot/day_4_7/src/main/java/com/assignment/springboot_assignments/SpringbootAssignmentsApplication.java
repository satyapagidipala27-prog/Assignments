package com.assignment.springboot_assignments;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@EnableJpaAuditing
@SpringBootApplication
public class SpringbootAssignmentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAssignmentsApplication.class, args);
	}

}
