package vn.vti.dtn2501.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vn.vti.dtn2501.common.api.exeption.EnableExceptionHandler;
import vn.vti.dtn2501.queue.common.EnableCommonQueueConsumer;

@SpringBootApplication
@EnableExceptionHandler
@EnableCommonQueueConsumer
public class NotificationServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(NotificationServiceApplication.class, args);
  }
}
