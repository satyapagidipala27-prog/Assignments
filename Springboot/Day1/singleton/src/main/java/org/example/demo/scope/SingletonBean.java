package org.example.demo.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class SingletonBean {

    public SingletonBean() {
        System.out.println("SingletonBean: Constructor");
    }

    @PostConstruct
    public void init() {
        System.out.println("SingletonBean: Initialized");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("SingletonBean: Destroyed");
    }

    public void showMessage() {
        System.out.println("SingletonBean instance: " + this);
    }
}
