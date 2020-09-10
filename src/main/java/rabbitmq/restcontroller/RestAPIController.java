package rabbitmq.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import rabbitmq.rabbitmq.rabbitmqconfig.rabbitMQPublishers.RabbitMQPublisherForFanoutExchange;
import rabbitmq.rabbitmq.rabbitmqconfig.rabbitMQPublishers.RabbitMQPublisherForQueueOne;
import rabbitmq.rabbitmq.rabbitmqconfig.rabbitMQPublishers.RabbitMQPublisherForQueueTwo;

@RestController
public class RestAPIController {
    @Autowired
    RabbitMQPublisherForQueueOne rabbitMQPublisherForQueueOne;

    @Autowired
    RabbitMQPublisherForQueueTwo rabbitMQPublisherForQueueTwo;

    @Autowired
    RabbitMQPublisherForFanoutExchange rabbitMQPublisherForFanoutExchange;

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
            default:
                System.out.println("No message was published!");
        }
        return new ResponseEntity<String>("Hello World", HttpStatus.OK);
    }
}
