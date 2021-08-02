package com.example.controller;

import com.example.model.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Repository("")
public class UserController {
    @GetMapping
    public ModelAndView showLogin(){
        return new ModelAndView("login","user",new User());
    }
    @PostMapping("/doLogin")
    public ModelAndView loginResult(@ModelAttribute User user){
        if(user.getPassword()==""){
            return new ModelAndView("error","msg","Try again");
        }
        return new ModelAndView("dashboard","user",user);
    }
}