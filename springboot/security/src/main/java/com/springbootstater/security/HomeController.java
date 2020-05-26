package com.springbootstater.security;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
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

    @GetMapping("/guest")
    public String guest(){
        return("<h1 style='color:blue'>Anyone can access this!<h1>");
    }
}
