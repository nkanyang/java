package com.springbootstarter.securityjpa;

import com.springbootstarter.securityjpa.models.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupController {

    @Autowired
    SignupService signupService;

    @GetMapping("/signup")
    public String signup(){
        return("<h1 style='color:blue'>Wellcome to signup<h1>");
    }

    @PostMapping("/signup")
    public void createNewUser(@RequestBody UserDto user){
        signupService.createNewUser(user);
    }
}
