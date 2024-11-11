package com.fdifrison.producer.sender;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class FanoutSenderService {

    private final RabbitTemplate rabbitTemplate;
    private final FanoutExchange fanoutExchange;

    public FanoutSenderService(RabbitTemplate rabbitTemplate, FanoutExchange fanoutExchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.fanoutExchange = fanoutExchange;
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        System.out.println("Sending message: to all the receivers!");
        rabbitTemplate.convertAndSend(fanoutExchange.getName(), "", "Hello receiver!");
    }
}
