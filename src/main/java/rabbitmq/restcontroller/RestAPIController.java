package rabbitmq.restcontroller;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import rabbitmq.rabbitmqconfig.rabbitMQPublishers.RabbitMQBatchPublisher;
import rabbitmq.rabbitmqconfig.rabbitMQPublishers.RabbitMQPublisherForFanoutExchange;
import rabbitmq.rabbitmqconfig.rabbitMQPublishers.RabbitMQPublisherForQueueNine;
import rabbitmq.rabbitmqconfig.rabbitMQPublishers.RabbitMQPublisherForQueueOne;
import rabbitmq.rabbitmqconfig.rabbitMQPublishers.RabbitMQPublisherForQueueTen;
import rabbitmq.rabbitmqconfig.rabbitMQPublishers.RabbitMQPublisherForQueueTwo;
import rabbitmq.rabbitmqconfig.rabbitMQPublishers.RabbitMQPublisherForTopicExchange;

@RestController
public class RestAPIController {
    @Autowired
    RabbitMQPublisherForQueueOne rabbitMQPublisherForQueueOne;

    @Autowired
    RabbitMQPublisherForQueueTwo rabbitMQPublisherForQueueTwo;

    @Autowired
    RabbitMQPublisherForQueueNine rabbitMQPublisherForQueueNine;

    @Autowired
    RabbitMQPublisherForQueueTen rabbitMQPublisherForQueueTen;

    @Autowired
    RabbitMQPublisherForFanoutExchange rabbitMQPublisherForFanoutExchange;

    @Autowired
    RabbitMQPublisherForTopicExchange rabbitMQPublisherForTopicExchange;

    @Autowired
    RabbitMQBatchPublisher rabbitMQBatchPublisher;

    @GetMapping(value = "/sendMsg/{id}")
    public ResponseEntity<String> publishMessage(@PathVariable("id") int id) {
        switch(id) {
            case 1:
                rabbitMQPublisherForQueueOne.send("This message is sent to queue one!");
                break;
            case 2:
                rabbitMQPublisherForQueueTwo.send("This message is sent to queue two!");
                break;
            case 3:
            case 4:
                rabbitMQPublisherForFanoutExchange.send("This message is sent to queue "+id+"!");
                break;
            case 5:
                rabbitMQPublisherForTopicExchange.send("This message is sent with routing key route.queue_five", "route.queue_five");
                break;
            case 6:
                rabbitMQPublisherForTopicExchange.send("This message is sent with routing key route.queue_seven", "route.queue_seven");
                break;
            case 9:
                rabbitMQPublisherForQueueNine.send("This message is sent with routing key route.queue_nine");
                break;
            case 10:
                for ( int i = 0 ; i < 10 ; i++ ) {
                    rabbitMQPublisherForQueueTen.send("["+i+"] This message is sent to queue ten!");
                }
                break;
            default:
                System.out.println("No message was published!");
        }
        return new ResponseEntity<String>("Hello World", HttpStatus.OK);
    }

    @GetMapping(value = "/batchItLikeYouMeanIt")
    public ResponseEntity<String> publishBatchMessages() {
        //GENERATE fake data for batching
        //Feed to batch rabbitmq
        for ( int i  = 0 ; i < 100 ; i++ ) {
            rabbitMQBatchPublisher.send(Faker.instance().princessBride().character()+" - "+i);
        }
        return new ResponseEntity<String>("Hello World", HttpStatus.OK);
    }
}
