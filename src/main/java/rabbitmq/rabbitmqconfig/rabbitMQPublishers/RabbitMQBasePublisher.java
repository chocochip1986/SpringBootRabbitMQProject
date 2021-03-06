package rabbitmq.rabbitmqconfig.rabbitMQPublishers;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQBasePublisher {
    @Autowired
    protected AmqpTemplate rabbitMQTemplate;
}
