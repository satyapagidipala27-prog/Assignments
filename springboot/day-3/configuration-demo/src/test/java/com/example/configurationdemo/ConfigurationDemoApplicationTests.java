package com.example.configurationdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ConfigurationDemoApplicationTests {
    @Autowired private MockMvc mockMvc;

    @Test
    void mailEndpointReturnsYamlConfiguration() throws Exception {
        mockMvc.perform(get("/api/config/mail"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.host").value("smtp.example.com"))
                .andExpect(jsonPath("$.port").value(587))
                .andExpect(jsonPath("$.enabled").value(true));
    }

    @Test
    void storageEndpointReturnsYamlConfiguration() throws Exception {
        mockMvc.perform(get("/api/config/storage"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.location").value("./uploads"))
                .andExpect(jsonPath("$.maxFileSizeMb").value(10))
                .andExpect(jsonPath("$.allowedExtensions[*]", containsInAnyOrder("pdf", "docx", "txt")));
    }
}
