package io.springboot.ioc_and_di.has_ioc_and_di;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary 
public class SmsNotificationService implements NotificationService {

    @Override 
    public String send() {
        return ">>>>>>> Sending SMS notification with IoC and DI...";
    }
}
