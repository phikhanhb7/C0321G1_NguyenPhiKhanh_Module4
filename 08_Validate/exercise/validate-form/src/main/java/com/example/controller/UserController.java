package com.example.controller;

import com.example.model.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("")
    public String goCreate(Model model){
        model.addAttribute("user",new User());
        return "/create";
    }

    @PostMapping("/create")
    public String result(@Validated @ModelAttribute("user") User user,BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return "/create";
        }
        return "view";
    }
}
