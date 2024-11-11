package com.fdifrison.consumer.configuration;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicConfig {

    @Bean
    public TopicExchange topic() {
        return new TopicExchange("topic");
    }


    @Bean
    public Queue autoDeleteQueue5() {
        return new AnonymousQueue();
    }

    @Bean
    public Queue autoDeleteQueue6() {
        return new AnonymousQueue();
    }

    @Bean
    public Binding binding5a(TopicExchange topic,
                             Queue autoDeleteQueue5) {
        return BindingBuilder.bind(autoDeleteQueue5)
                .to(topic)
                .with("*.orange.*");
    }

    @Bean
    public Binding binding5b(TopicExchange topic,
                             Queue autoDeleteQueue5) {
        return BindingBuilder.bind(autoDeleteQueue5)
                .to(topic)
                .with("*.*.rabbit");
    }

    @Bean
    public Binding binding6(TopicExchange topic,
                             Queue autoDeleteQueue6) {
        return BindingBuilder.bind(autoDeleteQueue6)
                .to(topic)
                .with("lazy.#");
    }

}
