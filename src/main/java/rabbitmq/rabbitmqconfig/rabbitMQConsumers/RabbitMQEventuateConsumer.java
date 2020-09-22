package rabbitmq.rabbitmqconfig.rabbitMQConsumers;

import io.eventuate.tram.messaging.consumer.MessageConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQEventuateConsumer {
    @Autowired
    MessageConsumer messageConsumer;

    public void consume() {
        messageConsumer.subscribe();
    }
}
