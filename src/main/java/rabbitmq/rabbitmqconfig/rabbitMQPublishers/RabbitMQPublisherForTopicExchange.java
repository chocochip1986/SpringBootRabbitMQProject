package rabbitmq.rabbitmqconfig.rabbitMQPublishers;

import org.springframework.stereotype.Service;
import rabbitmq.constants.RabbitMQConstants;

@Service
public class RabbitMQPublisherForTopicExchange extends RabbitMQBasePublisher {
    public void send(String message) {
        this.rabbitMQTemplate.convertAndSend(RabbitMQConstants.TOPIC_EXCHANGE_ONE, null, message);
    }

    public void send(String message, String routingKey) {
        this.rabbitMQTemplate.convertAndSend(RabbitMQConstants.TOPIC_EXCHANGE_ONE, routingKey, message);
    }
}
