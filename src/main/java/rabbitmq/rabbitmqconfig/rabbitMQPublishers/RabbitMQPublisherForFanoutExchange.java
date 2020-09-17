package rabbitmq.rabbitmqconfig.rabbitMQPublishers;

import org.springframework.stereotype.Service;
import rabbitmq.constants.RabbitMQConstants;

@Service
public class RabbitMQPublisherForFanoutExchange extends RabbitMQBasePublisher {
    public void send(String message) {
        this.rabbitMQTemplate.convertAndSend(RabbitMQConstants.FANOUT_EXCHANGE_ONE, null, message);
    }
}
