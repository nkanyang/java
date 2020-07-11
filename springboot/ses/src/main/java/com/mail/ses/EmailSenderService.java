package com.mail.ses;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.*;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender amazonSimpleEmailService;

    @Async
    public void sendEmail()throws MessagingException{
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom("nkanyang@gmail.com");
        mail.setTo("jessiehan.au@gmail.com");
        mail.setSubject("new user");
        mail.setText("You are the best!");
        amazonSimpleEmailService.send(mail);
    }
}
