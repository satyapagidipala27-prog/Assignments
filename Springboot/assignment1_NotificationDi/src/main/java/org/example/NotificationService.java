package org.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service
public class NotificationService {
    private final Notification notification;
    public NotificationService(@Qualifier("emailNotification")  Notification notification) {
        this.notification = notification;
    }
    public void notifyUser() {
        notification.sendNotification();
    }
}
