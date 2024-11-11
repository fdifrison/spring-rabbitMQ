package com.fdifrison.producer.sender;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class BasicSenderService {

    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;

    public BasicSenderService(RabbitTemplate rabbitTemplate, @Qualifier("basic") Queue queue) {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        var message = "Hello World from RabbitMQ";
        // TODO not having an exchange for the simple case, rabbit will bound the queue to the default exchange that
        //  gets created with the same name of the queue itself.. hence queue.getName()
        rabbitTemplate.convertAndSend(queue.getName(), message);
        System.out.println("Sent message: " + message);
    }
}
