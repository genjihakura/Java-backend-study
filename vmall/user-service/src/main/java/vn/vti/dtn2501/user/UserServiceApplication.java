package vn.vti.dtn2501.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import vn.vti.dtn2501.common.api.exeption.EnableExceptionHandler;
import vn.vti.dtn2501.queue.common.EnableCommonQueuePublisher;

@SpringBootApplication
@EnableExceptionHandler
@EnableFeignClients
@EnableCommonQueuePublisher
public class UserServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(UserServiceApplication.class, args);
  }
}
