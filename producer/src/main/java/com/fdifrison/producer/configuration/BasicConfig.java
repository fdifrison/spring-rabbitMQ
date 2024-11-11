package com.fdifrison.producer.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BasicConfig {

    @Bean("basic")
    public Queue helloQueue() {
        return new Queue("basic");
    }

    @Bean("work")
    public Queue workQueue() {
        return new Queue("work");
    }
}
