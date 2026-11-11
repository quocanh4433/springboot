package io.springboot.ioc_and_di.no_ioc_and_di;

public class NotificationController {
    private final EmailNotificationService emailService;

    NotificationController () {
        this.emailService = new EmailNotificationService();
    }

    public void sendNotification() {
        emailService.send();
    }
}
