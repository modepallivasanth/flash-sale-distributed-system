package com.vasanth.projects.flashsale.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    // Define the queue name as a constant so we don't misspell it later
    public static final String ORDER_QUEUE = "order_queue";

    @Bean
    public Queue orderQueue() {
        // The 'true' parameter means this queue is durable.
        // If RabbitMQ crashes, it remembers the queue exists when it restarts.
        return new Queue(ORDER_QUEUE, true);
    }
}