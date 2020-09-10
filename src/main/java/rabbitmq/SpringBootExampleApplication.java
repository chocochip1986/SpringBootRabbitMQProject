package rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootExampleApplication {
    public static void main(String[] args) {
        System.out.println("System thread: "+Thread.currentThread().getId());
        SpringApplication.run(SpringBootExampleApplication.class, args);
    }
}
