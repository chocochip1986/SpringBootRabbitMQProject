package rabbitmq.rabbitmq.rabbitmqconfig.rabbitMQConsumers;

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
@RabbitListener(queues = {RabbitMQConstants.QUEUE_ONE, RabbitMQConstants.QUEUE_TWO},  containerFactory = "simpleManualRabbitListenerContainerFactory")
public class RabbitMQConsumer extends RabbitMQBaseConsumer {

    @RabbitHandler
    public void receive(String in, Message message,
                        @Header(AmqpHeaders.CHANNEL)Channel channel,
                        @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        rejectMessage(channel, tag);
        System.out.println(formattedMessageProperties(message.getMessageProperties()));
        super.receive(in);
    }

    private void rejectMessage(Channel channel, long tag) throws IOException {
        //Negative acknowledgements simply instruct RabbitMQ to record a message as delivered and can be discarded.
        channel.basicReject(tag, false);
    }

    private void nackMessage(Channel channel, long tag) throws IOException {
        channel.basicNack(tag, true, false);
    }

    private void ackMessage(Channel channel, long tag) throws IOException {
        //Positive acknowledgements simply instruct RabbitMQ to record a message as delivered and can be discarded.
        channel.basicAck(tag, false);
    }
}
