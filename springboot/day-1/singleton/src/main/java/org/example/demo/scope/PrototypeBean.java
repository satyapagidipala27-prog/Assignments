package org.example.demo.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeBean {

    public PrototypeBean() {
        System.out.println("PrototypeBean: Constructor");
    }

    @PostConstruct
    public void init() {
        System.out.println("PrototypeBean: Initialized");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("PrototypeBean: Destroyed");
    }

    public void showMessage() {
        System.out.println("PrototypeBean instance: " + this);
    }
}