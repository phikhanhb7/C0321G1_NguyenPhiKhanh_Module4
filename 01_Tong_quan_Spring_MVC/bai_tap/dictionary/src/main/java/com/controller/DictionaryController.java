package com.controller;

import com.service.IListDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DictionaryController {

    @Autowired
    IListDictionaryService dictionaryService;

    @GetMapping(value = "/")
    public String goIndex() {
        return "home";
    }


    @PostMapping(value = "/dictionary")
    public ModelAndView result(@RequestParam String name) {
        return new ModelAndView("result", "result", dictionaryService.find(name));
    }
}
