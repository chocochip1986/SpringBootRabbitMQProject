package rabbitmq.rabbitmq.rabbitmqconfig;

import org.springframework.amqp.core.Binding;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rabbitmq.constants.RabbitMQConstants;

@Configuration
public class RabbitMQBinding {
    @Bean
    public Binding queueOneBinding(Queue queueOne, DirectExchange directExchange) {
        return BindingBuilder.bind(queueOne).to(directExchange).with(RabbitMQConstants.QUEUE_ONE_ROUTING_KEY);
    }

    @Bean
    public Binding queueTwoBinding(Queue queueTwo, DirectExchange directExchange) {
        return BindingBuilder.bind(queueTwo).to(directExchange).with(RabbitMQConstants.QUEUE_TWO_ROUTING_KEY);
    }

    @Bean
    public Binding queueEightBinding(Queue queueEight, DirectExchange directExchange) {
        return BindingBuilder.bind(queueEight).to(directExchange).with(RabbitMQConstants.QUEUE_EIGHT_ROUTING_KEY);
    }

    @Bean
    public Binding queueTenBinding(Queue queueTen, DirectExchange directExchange) {
        return BindingBuilder.bind(queueTen).to(directExchange).with(RabbitMQConstants.QUEUE_TEN_ROUTING_KEY);
    }

    @Bean
    public Binding queueThreeBindingForFanoutExchange(Queue queueThree, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueThree).to(fanoutExchange);
    }

    @Bean
    public Binding queueFourBindingForFanoutExchange(Queue queueFour, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueFour).to(fanoutExchange);
    }

    @Bean
    public Binding queueSevenBindingForFanoutExchange(Queue queueSeven, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueSeven).to(fanoutExchange);
    }

    @Bean
    public Binding queueFiveBindingForTopicExchange(Queue queueFive, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueFive).to(topicExchange).with(RabbitMQConstants.QUEUE_FIVE_ROUTING_KEY);
    }

    @Bean
    public Binding queueSixBindingForTopicExchange(Queue queueSix, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueSix).to(topicExchange).with(RabbitMQConstants.QUEUE_SIX_ROUTING_KEY);
    }

    @Bean
    public Binding queueSixGenericBindingForTopicExchange(Queue queueSix, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueSix).to(topicExchange).with(RabbitMQConstants.QUEUE_SIX_GENRIC_ROUTING_KEY);
    }

    @Bean
    public Binding queueNineBindingForDirectExchange(Queue queueNine, DirectExchange directExchange) {
        return BindingBuilder.bind(queueNine).to(directExchange).with(RabbitMQConstants.QUEUE_NINE_ROUTING_KEY);
    }
}
