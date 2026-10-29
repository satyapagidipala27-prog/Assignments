package com.example.spring_foundation;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomJacksonConfig {

    @Bean
    public ObjectMapper objectMapper() {
        System.out.println("Creating custom ObjectMapper");

        return new ObjectMapper().findAndRegisterModules();
    }
}


