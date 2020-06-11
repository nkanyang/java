package com.springbootstarter.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageListener {
    private List<String> messages= new ArrayList<>();
    private boolean needClear = false;

    @RabbitListener(queues = RabbitMQConfig.queueName)
    public void getMessage(String message){
        System.out.println(message);
        if(needClear == true){
            messages.clear();
            needClear = false;
        }
        messages.add(message);
        return;
    }

    public List<String> getMessages(){
        System.out.println("send all the new messages to browser");
        needClear = true;
        return messages;
    }
}
