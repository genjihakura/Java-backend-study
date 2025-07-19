package vn.vti.dtn2501.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import vn.vti.dtn2501.common.api.exeption.EnableExceptionHandler;

@SpringBootApplication
@EnableExceptionHandler
public class MallServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(MallServiceApplication.class, args);
  }
}
