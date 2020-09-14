package rabbitmq.rabbitmq.rabbitmqconfig.rabbitMQPublishers;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.MessagePropertiesBuilder;
import org.springframework.amqp.rabbit.core.BatchingRabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rabbitmq.constants.RabbitMQConstants;

import java.util.List;

@Service
public class RabbitMQBatchPublisher {
    @Autowired
    protected BatchingRabbitTemplate batchRabbitMQTemplate;

    public void send(String payload) {
        Message message = new Message(payload.getBytes(), MessagePropertiesBuilder
                .newInstance()
                .setContentType(MessageProperties.CONTENT_TYPE_TEXT_PLAIN)
                .build());
        batchRabbitMQTemplate.send(RabbitMQConstants.DIRECT_EXCHANGE_ONE,
                RabbitMQConstants.QUEUE_EIGHT_ROUTING_KEY,
                message,
                null);
    }
}
