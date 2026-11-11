package io.springboot.ioc_and_di.has_ioc_and_di;

import org.springframework.stereotype.Service;

@Service 
public class EmailNotificationService implements NotificationService {

    @Override 
    public String send() {
        return ">>>>>>> Sending email notification with IoC and DI...";
    }
}
