package com.fdifrison.consumer.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues = "basic")
public class BasicReceiver {

    @RabbitHandler
    public void receive(String message) {
        System.out.println("Received: " + message);
    }
}
