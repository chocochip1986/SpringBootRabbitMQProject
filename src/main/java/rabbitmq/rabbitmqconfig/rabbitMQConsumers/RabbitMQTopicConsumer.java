package rabbitmq.rabbitmqconfig.rabbitMQConsumers;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import rabbitmq.constants.RabbitMQConstants;

@Component
@RabbitListener(queues = {RabbitMQConstants.QUEUE_FIVE, RabbitMQConstants.QUEUE_SIX}, containerFactory = "simpleRabbitListenerContainerFactory")
public class RabbitMQTopicConsumer extends RabbitMQBaseConsumer {
    @RabbitHandler
    public void receive(String in, Message message) {
        System.out.println(formattedMessageProperties(message.getMessageProperties()));
        super.receive(in);
    }
}
