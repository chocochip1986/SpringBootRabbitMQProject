package rabbitmq.rabbitmqconfig.rabbitMQConsumers;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import rabbitmq.constants.RabbitMQConstants;

@Component
@RabbitListener(queues = {RabbitMQConstants.QUEUE_FOUR}, containerFactory = "simpleRabbitListenerContainerFactory")
public class RabbitMQFanoutConsumerTwo extends RabbitMQBaseConsumer {
    @RabbitHandler
    public void receive(String in, Message message) {
        System.out.println("RabbitMQFanoutConsumerTwo: \n"+formattedMessageProperties(message.getMessageProperties())+
                "\nTime: "+System.currentTimeMillis());
        super.receive(in);
    }
}
