package com.example.configurationdemo.service;

import com.example.configurationdemo.config.MailProperties;
import com.example.configurationdemo.config.StorageProperties;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationService {
    private final MailProperties mail;
    private final StorageProperties storage;

    public ConfigurationService(MailProperties mail, StorageProperties storage) {
        this.mail = mail;
        this.storage = storage;
    }

    public MailProperties getMail() { return mail; }
    public StorageProperties getStorage() { return storage; }
}
