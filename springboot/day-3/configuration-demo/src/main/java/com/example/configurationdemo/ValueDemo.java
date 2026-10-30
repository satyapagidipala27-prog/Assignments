package com.example.configurationdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ValueDemo {
    @Value("${app.mail.host}") private String mailHost;
    @Value("${app.mail.port}") private int mailPort;

    public String getDetails() { return "Mail Host: " + mailHost + ", Port: " + mailPort; }
}
