package rabbitmq.rabbitmq.rabbitmqconfig;


import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.batch.SimpleBatchingStrategy;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.BatchingRabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.TaskScheduler;
import rabbitmq.constants.RabbitMQConstants;

@EnableRabbit //If you wanna use SimpleRabbitListenerContainerFactory to enable support for @RabbitListener
@Configuration
public class RabbitMQConfig {
    /*
    A direct exchange delivers messages to queues based on a message routing key.
    The routing key is a message attribute added to the message header by the producer.
    Think of the routing key as an "address" that the exchange is using to decide how to route the message.
    A message goes to the queue(s) with the binding key that exactly matches the routing key of the message.
    The direct exchange type is useful to distinguish messages published to the same exchange using a simple string identifier
     */
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(RabbitMQConstants.DIRECT_EXCHANGE_ONE);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(RabbitMQConstants.FANOUT_EXCHANGE_ONE);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(RabbitMQConstants.TOPIC_EXCHANGE_ONE);
    }

    @Bean
    public SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory = new SimpleRabbitListenerContainerFactory();
        simpleRabbitListenerContainerFactory.setConnectionFactory(connectionFactory);
        simpleRabbitListenerContainerFactory.setMessageConverter(jsonMessageConverter());
        return simpleRabbitListenerContainerFactory;
    }

    @Bean
    public SimpleRabbitListenerContainerFactory simpleManualRabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory = new SimpleRabbitListenerContainerFactory();
        simpleRabbitListenerContainerFactory.setConnectionFactory(connectionFactory);
        simpleRabbitListenerContainerFactory.setMessageConverter(jsonMessageConverter());
        simpleRabbitListenerContainerFactory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        return simpleRabbitListenerContainerFactory;
    }

    @Bean
    public SimpleRabbitListenerContainerFactory batchRabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory = new SimpleRabbitListenerContainerFactory();
        simpleRabbitListenerContainerFactory.setConnectionFactory(connectionFactory);
        simpleRabbitListenerContainerFactory.setBatchSize(5); //Note that this may be exceeded by the broker pumping messages in.
        simpleRabbitListenerContainerFactory.setConsumerBatchEnabled(true); //You need to set this flag to true if you want the listening container to create a batch of messages.
        simpleRabbitListenerContainerFactory.setBatchListener(true); //you can configure the listener container factory and listener to receive the entire batch in one call
        return simpleRabbitListenerContainerFactory;
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Primary
    @Bean
    public AmqpTemplate rabbitMQTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        rabbitTemplate.setExchange(RabbitMQConstants.DIRECT_EXCHANGE_ONE);
        return rabbitTemplate;
    }

    @Bean(value = "batchRabbit")
    public BatchingRabbitTemplate batchRabbitMQTemplate(ConnectionFactory connectionFactory, TaskScheduler taskScheduler) {
        SimpleBatchingStrategy simpleBatchingStrategy = new SimpleBatchingStrategy(RabbitMQConstants.BATCH_SIZE, RabbitMQConstants.BUFFER_LIMIT, RabbitMQConstants.BATCH_TIMEOUT);
        final BatchingRabbitTemplate batchingRabbitTemplate = new BatchingRabbitTemplate(simpleBatchingStrategy, taskScheduler);
        batchingRabbitTemplate.setConnectionFactory(connectionFactory);
        batchingRabbitTemplate.setExchange(RabbitMQConstants.DIRECT_EXCHANGE_ONE);
        batchingRabbitTemplate.afterPropertiesSet();
        return batchingRabbitTemplate;
    }
}
