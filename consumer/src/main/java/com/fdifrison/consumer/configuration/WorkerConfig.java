package com.fdifrison.consumer.configuration;

import com.fdifrison.consumer.listener.WorkLoadReceiver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WorkerConfig {

    @Bean
    public WorkLoadReceiver receiver1() {
        return new WorkLoadReceiver(1);
    }

    @Bean
    public WorkLoadReceiver receiver2() {
        return new WorkLoadReceiver(2);
    }
}
