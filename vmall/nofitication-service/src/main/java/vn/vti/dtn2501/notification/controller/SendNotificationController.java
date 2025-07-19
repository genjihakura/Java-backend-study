package vn.vti.dtn2501.notification.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.vti.dtn2501.notification.payload.request.SendNotificationRequest;
import vn.vti.dtn2501.notification.service.ISendNotificationService;

@RequestMapping(value = "/internal/api/v1/notifications")
@RestController
@RequiredArgsConstructor
public class SendNotificationController {  
  private final ISendNotificationService notificationService;

  @PostMapping
  public ResponseEntity<Void> sendNotification(
      @RequestBody SendNotificationRequest request) {
    notificationService.sendNotification(request);
    return ResponseEntity.noContent().build();
  }
}
