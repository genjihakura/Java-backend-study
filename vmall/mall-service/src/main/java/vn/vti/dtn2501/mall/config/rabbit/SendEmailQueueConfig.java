package vn.vti.dtn2501.mall.config.rabbit;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import vn.vti.dtn2501.mall.payload.request.SendNotificationRequest;

@Configuration
public class SendEmailQueueConfig {
    private final String  routingKey;
    private final String queueName;

    private final String exchangeName;

    public SendEmailQueueConfig( QueueConfigProperties queueConfigProperties)
    {
        var sendEmailQueueConfig = queueConfigProperties.getSendNotification();
        this.routingKey = sendEmailQueueConfig.getRoutingKey();
        this.queueName = sendEmailQueueConfig.getQueueName();
        this.exchangeName = sendEmailQueueConfig.getExchange();

        System.out.println("SendEmailQueueConfig " + this.routingKey + " "  + this.queueName + " " + this.exchangeName);
    }

    @Bean
    DirectExchange sendEmailExchange() {
        return new DirectExchange(exchangeName);
    }

    @Bean
    public Queue sendEmailQueue() {
        return QueueBuilder.durable(queueName).build();
    }

    @Bean
    Binding bpEventDetailCmpBinding(Queue sendEmailQueue,
                                    DirectExchange sendEmailExchange) {
        return BindingBuilder
                .bind(sendEmailQueue)
                .to(sendEmailExchange)
                .with(routingKey);
    }
}

