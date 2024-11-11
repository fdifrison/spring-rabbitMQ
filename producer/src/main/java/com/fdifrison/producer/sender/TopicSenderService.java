package com.fdifrison.producer.sender;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class TopicSenderService {

    private final RabbitTemplate rabbitTemplate;
    private final TopicExchange topicExchange;



    private final String[] keys = {"quick.orange.rabbit", "lazy.orange.elephant", "quick.orange.fox",
            "lazy.brown.fox", "lazy.pink.rabbit", "quick.brown.fox"};

    public TopicSenderService(RabbitTemplate rabbitTemplate, TopicExchange topicExchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.topicExchange = topicExchange;
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        var i = new Random().nextInt(keys.length);
        System.out.println("Sending message to key [" + keys[i] + "]");
        rabbitTemplate.convertAndSend(topicExchange.getName(), keys[i], "Hello [" + keys[i] + "] receiver!");
    }

}
