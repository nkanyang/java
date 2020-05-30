package com.springbootstarter.securityjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    @GetMapping("/")
    public String home(){
        return("<h1 style='color:blue'>Wellcome to Jessie's Homepage<h1>");
    }

    @GetMapping("/admin")
    public String admin(){
        return("<h1 style='color:blue'>Only Administrator Can Access me!<h1>");
    }

    @GetMapping("/user")
    public String user(){
        return("<h1 style='color:blue'>Only Administrator and User Can Access me!<h1>");
    }

}

