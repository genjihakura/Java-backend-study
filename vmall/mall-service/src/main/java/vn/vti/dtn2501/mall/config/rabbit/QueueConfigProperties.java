package vn.vti.dtn2501.mall.config.rabbit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import vn.vti.dtn2501.queue.common.properties.SingleQueueConfigProperties;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "queue")
public class QueueConfigProperties {
    private SingleQueueConfigProperties sendNotification;
}
