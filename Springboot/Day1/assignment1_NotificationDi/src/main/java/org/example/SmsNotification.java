package org.example;
import org.springframework.stereotype.Component;
@Component("smsNotification")
class SmsNotification implements Notification {
    @Override
    public void sendNotification(){
        System.out.println("Sending SMS notification");
    }

}
