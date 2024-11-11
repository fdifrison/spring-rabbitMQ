package com.fdifrison.producer.sender;

import java.util.Random;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class DirectSenderService {

    private final RabbitTemplate rabbitTemplate;
    private final DirectExchange directExchange;

    public DirectSenderService(RabbitTemplate rabbitTemplate, DirectExchange directExchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.directExchange = directExchange;
    }

    private final String[] keys = {"orange", "black", "green"};

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        var i = new Random().nextInt(keys.length);
        System.out.println("Sending message to key [" + keys[i] + "]");
        rabbitTemplate.convertAndSend(directExchange.getName(), keys[i], "Hello [" + keys[i] + "] receiver!");
    }
}
