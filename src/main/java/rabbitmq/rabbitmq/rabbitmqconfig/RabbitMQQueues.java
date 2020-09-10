package rabbitmq.rabbitmq.rabbitmqconfig;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rabbitmq.constants.RabbitMQConstants;

@Configuration
public class RabbitMQQueues {
    //Direct Queues
    @Bean
    public Queue queueOne() {
        return new Queue(RabbitMQConstants.QUEUE_ONE);
    }

    @Bean
    public Queue queueTwo() {
        return new Queue(RabbitMQConstants.QUEUE_TWO);
    }

    //Fanout Queues
    @Bean
    public Queue queueThree() {
        return new Queue(RabbitMQConstants.QUEUE_THREE);
    }

    @Bean
    public Queue queueFour() {
        return new Queue(RabbitMQConstants.QUEUE_FOUR);
    }
}
