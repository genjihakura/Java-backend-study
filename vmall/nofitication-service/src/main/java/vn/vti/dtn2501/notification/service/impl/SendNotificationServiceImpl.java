package vn.vti.dtn2501.notification.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.vti.dtn2501.notification.payload.request.SendNotificationRequest;
import vn.vti.dtn2501.notification.service.ISendNotificationService;

@Service
@Slf4j
public class SendNotificationServiceImpl implements ISendNotificationService {

  @Override
  public void sendNotification(SendNotificationRequest request) {
    log.info("Sending notification to [{}] with content: [{}]",
        request.getTo(),
        request.getContent());
  }
}
