package com.fdifrison.producer.sender;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class WorkSenderService {

    private final RabbitTemplate rabbitTemplate;

    private final Queue queue;

    public WorkSenderService(RabbitTemplate rabbitTemplate, @Qualifier("work") Queue queue) {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        var message = "Publishing a long task";
        rabbitTemplate.convertAndSend(queue.getName(), message);
        System.out.println("Sent '" + message + "'");
    }
}
