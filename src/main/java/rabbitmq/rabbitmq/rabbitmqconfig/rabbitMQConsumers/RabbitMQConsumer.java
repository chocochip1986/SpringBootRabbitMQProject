package rabbitmq.rabbitmq.rabbitmqconfig.rabbitMQConsumers;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import rabbitmq.constants.RabbitMQConstants;

@Component
@RabbitListener(queues = {RabbitMQConstants.QUEUE_ONE, RabbitMQConstants.QUEUE_TWO},  containerFactory = "simpleRabbitListenerContainerFactory")
public class RabbitMQConsumer extends RabbitMQBaseConsumer {

    @RabbitHandler
    public void receive(String in, Message message) {
        System.out.println(formattedMessageProperties(message.getMessageProperties()));
        super.receive(in);
    }
}
