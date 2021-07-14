package com.controller;

import com.service.ListDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DictionaryController {

    ListDictionary listDictionary = new ListDictionary() ;

    @GetMapping(value = "/")
    public String goIndex(){
        return "home";
    }
    @PostMapping( value = "/dictionary")
    public ModelAndView result(@RequestParam String name){
        String result = listDictionary.find(name);
        ModelAndView modelAndView = new ModelAndView("result","result",result);
        return  modelAndView;
    }
    }
