package com.example.controller;

import com.example.model.dto.UserDto;
import com.example.model.entity.User;
import com.example.model.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping("")
    public String goCreate(Model model){
        model.addAttribute("userDto",new UserDto());
        return "/create";
    }

    @PostMapping("/create")
    public String result(@Validated @ModelAttribute("userDto") UserDto userDto,BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return "/create";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        userService.save(user);
        return "view";
    }
}
