package rabbitmq.rabbitmq.rabbitmqconfig.rabbitMQPublishers;

import org.springframework.stereotype.Service;
import rabbitmq.constants.RabbitMQConstants;

@Service
public class RabbitMQPublisherForQueueTen extends RabbitMQBasePublisher {
    public void send(String message) {
        this.rabbitMQTemplate.convertAndSend(RabbitMQConstants.QUEUE_TEN_ROUTING_KEY, message);
    }
}
