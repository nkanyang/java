package com.mail.ses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;


@RestController
public class MailController {
    @Autowired
    private EmailSenderService emailSenderService;
    @GetMapping("/mail")
    public String sendMail() throws MessagingException{
        emailSenderService.sendEmail();
        return "Check your email";
    }
}
