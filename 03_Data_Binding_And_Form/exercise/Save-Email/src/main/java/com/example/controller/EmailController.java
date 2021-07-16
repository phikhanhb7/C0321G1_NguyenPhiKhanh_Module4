package com.example.controller;

import com.example.model.Email;
import com.example.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailController {
    @Autowired
    IEmailService emailService ;

    @GetMapping("/")
    public String goUpdate(Model model){
        model.addAttribute("email",new Email());
        return "edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("email") Email email, Model model){
        emailService.update(email);
        model.addAttribute("email",email);
        return "show";
    }
}
