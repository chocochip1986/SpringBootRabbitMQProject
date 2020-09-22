package rabbitmq.rabbitmqconfig.rabbitMQPublishers;

import io.eventuate.tram.messaging.common.Message;
import io.eventuate.tram.messaging.producer.MessageBuilder;
import io.eventuate.tram.messaging.producer.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rabbitmq.constants.RabbitMQConstants;

@Service
public class RabbitMQEventuatePublisher {
    @Autowired
    private MessageProducer messageProducer;

    public void sendMessage(String message) {
        messageProducer.send(RabbitMQConstants.QUEUE_ONE, buildMessage(message));
    }

    private Message buildMessage(String message) {
        return MessageBuilder.withPayload(message).build();
    }
}
