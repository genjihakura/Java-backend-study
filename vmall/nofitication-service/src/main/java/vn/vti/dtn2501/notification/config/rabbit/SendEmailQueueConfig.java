package vn.vti.dtn2501.notification.config.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SendEmailQueueConfig {
  private final String  routingKey;
  private final String queueName;

  private final String exchangeName;

  public SendEmailQueueConfig(
      QueueConfigProperties queueConfigProperties
  ){
    var sendEmailQueueConfig = queueConfigProperties.getSendNotification();
    this.routingKey = sendEmailQueueConfig.getRoutingKey();
    this.queueName = sendEmailQueueConfig.getQueueName();
    this.exchangeName = sendEmailQueueConfig.getExchange();
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
