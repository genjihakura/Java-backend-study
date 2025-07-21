package vn.vti.dtn2501.notification.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import vn.vti.dtn2501.notification.payload.request.SendNotificationRequest;

@Component
@Slf4j
@RequiredArgsConstructor
public class SendNotificationListener {

  @RabbitListener(
      queues = "#{queueConfigProperties.getSendNotification().getQueueName()}"
  )
  public void listenSendNotificationRequest(
      SendNotificationRequest sendNotificationRequest
  ) {
    log.info("(listenSendNotificationRequest)target: [{}] with content: [{}]",
        sendNotificationRequest.getTo(),
        sendNotificationRequest.getContent());

  }
}
