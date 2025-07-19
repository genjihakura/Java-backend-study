package vn.vti.dtn2501.notification.service;

import vn.vti.dtn2501.notification.payload.request.SendNotificationRequest;

public interface ISendNotificationService {
  void sendNotification(SendNotificationRequest request);
}
