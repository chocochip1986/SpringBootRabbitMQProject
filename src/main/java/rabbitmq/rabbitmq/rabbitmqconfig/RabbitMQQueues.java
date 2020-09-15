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

    @Bean
    public Queue queueTen() {
        return new Queue(RabbitMQConstants.QUEUE_TEN);
    }

    //Direct queue with manual ack/nack
    @Bean
    public Queue queueNine() {
        return new Queue(RabbitMQConstants.QUEUE_NINE);
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

    @Bean
    public Queue queueSeven() {
        return new Queue(RabbitMQConstants.QUEUE_SEVEN);
    }

    //Topic Exchange
    @Bean
    public Queue queueFive() {
        return new Queue(RabbitMQConstants.QUEUE_FIVE);
    }

    @Bean
    public Queue queueSix() {
        return new Queue(RabbitMQConstants.QUEUE_SIX);
    }

    //For batch rabbitmq
    @Bean
    public Queue queueEight() {
        return new Queue(RabbitMQConstants.QUEUE_EIGHT);
    }
}
