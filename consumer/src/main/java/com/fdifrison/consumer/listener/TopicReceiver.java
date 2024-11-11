package com.fdifrison.consumer.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class TopicReceiver {
    @RabbitListener(queues = "#{autoDeleteQueue5.name}")
    public void receive1(String message) {
        System.out.println("Queue 5 received: " + message);
    }

    @RabbitListener(queues = "#{autoDeleteQueue6.name}")
    public void receive2(String message) {
        System.out.println("Queue 6 received: " + message);
    }
}
