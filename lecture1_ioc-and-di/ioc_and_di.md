
## IoC và DI là gì?

| IoC (Invertion of Control) | DI (Dependency Injection) |
| --- | --- |
| Ý tưởng thiết kế | Cách để thực hiện IoC |

## Comparation DI Type

### 1. Constructure Injection

```java
@Service
public class NotificationService {
    public void send() {
        System.out.println("Sending notification");
    }
}d


@RestController
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/notify")
    public String notifyUser() {
        notificationService.send();
        return "Success";
    }
}
```

#### Ưu điểm
- đảm bảo đủ dependency khi khởi tạo
- đảm bảo object không null khi khởi tạo 
- có thể dùng từ khóa ``final``
- dễ units test
- phát hiện sớm circular dependency khi khởi tạo

#### Nhược điểm
- constructor có quá nhiều tham số
- circular dependency (ohuj thuộc vòng tròn)
- không phù hợp với trường hợp dependency optional



### 2. Setter Injection
```java
@RestController
public class NotificationController {

    private NotificationService notificationService;

    @Autowired
    public void setNotificationService(
            NotificationService notificationService) {
        this.notificationService = notificationService;
    }
}
```
#### Ưu điểm
- có thể thay dổi dependency sau khi khởi tạo
```java
controller.setNotificationService(newNotificationService);
```

- phù hợp với optional dependency: ``@Autowired(required = false)`` bỏ qua injection nếu không tìm thấy ``Bean`` 
```java
@Autowired(required = false)
public void setSmsService(SmsNotificationService smsService) {
    this.smsService = smsService;
}
```

#### Nhược điểm
- do có thể thay đổi dependency sau khi khởi tạo nên không thể sử dụng từ khóa ``final``

- có thể sử dụng Object trước khi set ịnection



### 3. Feild Injection
```java
@RestController
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

}
```

#### Ưu điểm
- code ngắn gọn


#### Nhược điểm
- khó unit test
- không thể khai báo ``final``, do ``final`` chỉ được gán 1 lần duy nhất tại thời điểm khai báo hoặc bên trong constructor. Nhưng feild injecttion thực hiện inject sau constructor.
- dependency bị ẩn khỏi constructor
- khó kiểm soát dependency bắt buộc


