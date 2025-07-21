package vn.vti.dtn2501.mall.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import vn.vti.dtn2501.mall.payload.request.SendNotificationRequest;

@FeignClient(name = "notification-service")
public interface NotificationClient {
    @PostMapping("/internal/api/v1/notifications")
    ResponseEntity<Void> sendNotification(@RequestBody SendNotificationRequest request);
}
