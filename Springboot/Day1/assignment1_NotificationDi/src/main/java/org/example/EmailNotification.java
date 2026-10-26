package org.example;

import org.springframework.stereotype.Component;

@Component("emailNotification")
public class EmailNotification implements Notification {
    @Override
    public void sendNotification() {
        System.out.println("Sending email notification");
    }
}
