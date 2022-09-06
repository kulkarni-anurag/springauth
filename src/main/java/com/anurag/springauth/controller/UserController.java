package com.anurag.springauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping(value = "/")
    public String showHomePage(){
        return "home";
    }
}
