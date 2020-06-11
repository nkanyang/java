package com.springbootstarter.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageContoller {

    @Autowired
    private MessageSender messageSender;

    @Autowired
    private MessageListener messageListener;

    @GetMapping
    List<String> getMessages(){
        return messageListener.getMessages();
    }

    @PostMapping
    void sendMessage(@RequestBody MyMessage message) throws Exception{
        messageSender.sendMessage(message);
        return;
    }
}
