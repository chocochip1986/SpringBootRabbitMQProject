package rabbitmq.rabbitmqconfig.rabbitMQConsumers;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import rabbitmq.constants.RabbitMQConstants;

import java.io.IOException;

@Component
@RabbitListener(queues = {RabbitMQConstants.QUEUE_ONE, RabbitMQConstants.QUEUE_TWO}, containerFactory = "simpleRabbitListenerContainerFactory")
public class RabbitMQConsumer extends RabbitMQBaseConsumer {

    @RabbitHandler
    public void receive(String in, Message message,
                        @Header(AmqpHeaders.CHANNEL)Channel channel,
                        @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        System.out.println(formattedMessageProperties(message.getMessageProperties()));
        super.receive(in);
    }
}
