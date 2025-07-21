package vn.vti.dtn2501.mall.queue.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import vn.vti.dtn2501.mall.config.rabbit.QueueConfigProperties;
import vn.vti.dtn2501.mall.payload.request.SendNotificationRequest;
import vn.vti.dtn2501.queue.common.Producer;
import vn.vti.dtn2501.queue.common.properties.SingleQueueConfigProperties;

@Component
@Qualifier("sendNotificationProducer")
@RequiredArgsConstructor
public class SendNotificationProducer implements Producer<SendNotificationRequest> {
    private final RabbitTemplate rabbitTemplate;
    private final QueueConfigProperties queueConfigProperties;

    @Override
    public void fire(SendNotificationRequest event) {
        SingleQueueConfigProperties notificationQueue = queueConfigProperties.getSendNotification();
        System.out.println("mall produce fire " + notificationQueue.getRoutingKey()+ " "+ notificationQueue.getRoutingKey());
        rabbitTemplate.convertAndSend(notificationQueue.getExchange(), notificationQueue.getRoutingKey(), event);
    }
}
