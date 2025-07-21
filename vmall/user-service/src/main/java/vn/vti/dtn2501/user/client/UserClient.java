package vn.vti.dtn2501.user.client;

import org.hibernate.annotations.Fetch;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import vn.vti.dtn2501.user.entity.UserDto;

@FeignClient(name = "user-service")
public interface UserClient {
    @GetMapping("/api/v1/accounts/{id}")
    UserDto getUserById(@PathVariable("id") Long id);
}
