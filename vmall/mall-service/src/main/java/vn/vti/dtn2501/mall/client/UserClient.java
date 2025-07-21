package vn.vti.dtn2501.mall.client;

//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import vn.vti.dtn2501.mall.entity.users.UserDto;

@FeignClient(name = "user-service")
public interface UserClient {

    @GetMapping("/api/v1/accounts/{id}")
    UserDto getUserById(@PathVariable Long id);
}
