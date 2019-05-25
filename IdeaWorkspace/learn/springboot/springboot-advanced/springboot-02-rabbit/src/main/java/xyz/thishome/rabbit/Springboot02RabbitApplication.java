package xyz.thishome.rabbit;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class Springboot02RabbitApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot02RabbitApplication.class, args);
    }

}

