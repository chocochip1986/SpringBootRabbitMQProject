package rabbitmq.rabbitmqconfig.rabbitMQConsumers;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import rabbitmq.constants.RabbitMQConstants;

@Component
@RabbitListener(queues = {RabbitMQConstants.QUEUE_THREE},  containerFactory = "simpleRabbitListenerContainerFactory")
public class RabbitMQFanoutConsumerOne extends RabbitMQBaseConsumer {
    @RabbitHandler
    public void receive(String in, Message message) {
        System.out.println("RabbitMQFanoutConsumerOne: \n"+formattedMessageProperties(message.getMessageProperties())+
                "\nTime: "+System.currentTimeMillis());
        super.receive(in);
    }
}
