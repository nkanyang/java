package com.springbootstarter.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    //rabbitMQ setup
    static final String exchangeName = "first";
    static final String queueName = "demo";
    static final String routingKey = "";

    @Bean
    org.springframework.amqp.core.Queue queue(){
        return new org.springframework.amqp.core.Queue(queueName,false);
    }

    @Bean
    TopicExchange exchange(){
        return new TopicExchange(exchangeName);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(routingKey);
    }

}
