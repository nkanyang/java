package com.springbootstarter.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageSender {
    static int counter = 0;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public MyMessage getMessage(){
        //get message from rabbitMQ and return it
        MyMessage message = new MyMessage();
        return message;
    }

    public void sendMessage(MyMessage message)throws Exception{
        //send the message to rabbitMQ
        message.setMessageCode(counter++);
        String jsonStr = this.objectMapper.writeValueAsString(message);
        this.rabbitTemplate.convertAndSend("first", "", jsonStr);
        return;
    }
}
