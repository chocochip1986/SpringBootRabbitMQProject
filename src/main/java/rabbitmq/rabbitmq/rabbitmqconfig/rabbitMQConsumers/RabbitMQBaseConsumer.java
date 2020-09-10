package rabbitmq.rabbitmq.rabbitmqconfig.rabbitMQConsumers;

import org.springframework.amqp.core.MessageProperties;

public class RabbitMQBaseConsumer {
    protected void receive(String in) {
        System.out.println("[x] Received: ["+in+"]");
    }

    protected String formattedMessageProperties(MessageProperties messageProperties) {
        String msgProp = "MESSAGE PROPERTIES: \nQUEUE: "+messageProperties.getConsumerQueue()+"\n"
                +"EXCHANGE: "+messageProperties.getReceivedExchange()+"\n"
                +"ROUTING_KEY: "+messageProperties.getReceivedRoutingKey()+"\n"
                +"Thread: "+Thread.currentThread().getId();
        return msgProp;
    }
}
