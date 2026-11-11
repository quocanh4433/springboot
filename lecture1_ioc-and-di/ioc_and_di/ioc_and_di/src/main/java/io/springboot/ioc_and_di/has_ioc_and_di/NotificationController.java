package io.springboot.ioc_and_di.has_ioc_and_di;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController 
public class NotificationController {
    private  NotificationService service;

    public NotificationController (NotificationService service) {
        this.service = service;
    }

    @GetMapping("/api/notification_ioc_di")
    public String sendNotification() {
        return service.send();
    }
}
