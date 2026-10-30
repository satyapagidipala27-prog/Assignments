package com.example.configurationdemo.controller;

import com.example.configurationdemo.service.ConfigurationService;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/config")
public class ConfigurationController {
    private final ConfigurationService service;

    public ConfigurationController(ConfigurationService service) { this.service = service; }

    @GetMapping("/mail")
    public Map<String, Object> getMail() {
        var mail = service.getMail();
        return Map.of("host", mail.getHost(), "port", mail.getPort(), "username", mail.getUsername(),
                "enabled", mail.isEnabled(), "from", mail.getFrom());
    }

    @GetMapping("/storage")
    public Map<String, Object> getStorage() {
        var storage = service.getStorage();
        return Map.of("location", storage.getLocation(), "maxFileSizeMb", storage.getMaxFileSizeMb(),
                "allowedExtensions", storage.getAllowedExtensions());
    }
}
