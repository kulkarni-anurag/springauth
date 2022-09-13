package com.anurag.springauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.anurag.springauth.model.User;
import com.anurag.springauth.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping(value = "/")
    public String showHomePage(ModelMap model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
            String username = ((UserDetails) principal).getUsername();

            model.addAttribute("username", username);
        }
        return "home";
    }

    @GetMapping(value = "/register")
    public String showRegisterPage(ModelMap model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping(value = "/register")
    public String handleRegistration(@ModelAttribute("user") User user, BindingResult result, ModelMap model){
        if(result.hasErrors()){
            return "register";
        }
        service.signup(user);
        return "redirect:login";
    }
}
