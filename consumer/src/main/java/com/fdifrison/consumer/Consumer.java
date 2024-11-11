package com.fdifrison.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class Consumer {

    public static void main(String[] args) {
        SpringApplication.run(Consumer.class, args);
    }
}
