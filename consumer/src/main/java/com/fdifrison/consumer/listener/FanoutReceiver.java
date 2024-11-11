package com.fdifrison.consumer.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class FanoutReceiver {

    @RabbitListener(queues = "#{autoDeleteQueue1.name}")
    public void receive1(String message) {
        System.out.println("Queue 1 received: " + message);
    }

    @RabbitListener(queues = "#{autoDeleteQueue2.name}")
    public void receive2(String message) {
        System.out.println("Queue 2 received: " + message);
    }
}
