package rabbitmq.rabbitmqconfig.rabbitMQConsumers;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rabbitmq.constants.RabbitMQConstants;

import java.util.List;


//A batch-enabled factory cannot be used with a multi-method listener.
@Component
public class RabbitMQBatchConsumer extends RabbitMQBaseConsumer {

    @Autowired
    MessageConverter jsonMessageConverter;


    //You need simpleRabbitListenerContainerFactory.setConsumerBatchEnabled(true); if you wanna receive the List of messages as a whole
    @RabbitListener(queues = {RabbitMQConstants.QUEUE_EIGHT}, containerFactory = "batchRabbitListenerContainerFactory")
    public void receive(List<Message> messages ) {
        for(Message message : messages) {
            System.out.println(formattedMessageProperties(message.getMessageProperties()));
            super.receive(new String(message.getBody()));
        }
    }
}
