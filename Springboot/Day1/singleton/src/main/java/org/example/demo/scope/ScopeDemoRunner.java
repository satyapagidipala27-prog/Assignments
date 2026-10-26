package org.example.demo.scope;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ScopeDemoRunner implements CommandLineRunner {

    private final ApplicationContext context;

    public ScopeDemoRunner(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void run(String... args) {

        System.out.println("\n--- SINGLETON TEST ---");

        SingletonBean s1 =
                context.getBean(SingletonBean.class);

        SingletonBean s2 =
                context.getBean(SingletonBean.class);

        s1.showMessage();
        s2.showMessage();

        System.out.println("Same singleton object? "
                + (s1 == s2));

        System.out.println("\n--- PROTOTYPE TEST ---");

        PrototypeBean p1 =
                context.getBean(PrototypeBean.class);

        PrototypeBean p2 =
                context.getBean(PrototypeBean.class);

        p1.showMessage();
        p2.showMessage();

        System.out.println("Same prototype object? "
                + (p1 == p2));
    }
}