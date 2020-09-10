package rabbitmq.rabbitmq.rabbitmqconfig.rabbitMQConsumers;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import rabbitmq.constants.RabbitMQConstants;

@Component
@RabbitListener(queues = {RabbitMQConstants.QUEUE_THREE, RabbitMQConstants.QUEUE_FOUR})
public class RabbitMQFanoutConsumer extends RabbitMQBaseConsumer {
    @RabbitHandler
    public void receive(String in, Message message) {
        System.out.println("MESSAGE PROPERTIES: \n"+formattedMessageProperties(message.getMessageProperties()));
        super.receive(in);
    }
}
