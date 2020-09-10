package rabbitmq.rabbitmq.rabbitmqconfig.rabbitMQConsumers;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import rabbitmq.constants.RabbitMQConstants;

@Component
@RabbitListener(queues = {RabbitMQConstants.QUEUE_ONE})
public class RabbitMQConsumerOne extends RabbitMQBaseConsumer {

    @RabbitHandler
    public void receive(String in ) {
        super.receive(in);
    }
}
