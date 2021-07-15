package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CondimentController {

    @GetMapping("/")
    public String goHome() {
        return "index";
    }

    @RequestMapping("/save")
    public String save(@RequestParam(value = "condiment", required = false) String[] condiments, Model model) {
        String result = "";
        if (condiments == null) {
            result = "You don't choose Sandwich";
        }else {
            for (String item : condiments) {
                if (item != null) {
                    result += item + "  ";
                }
            }
            if (result.equals("")) {
                result = "You don't choose Sandwich";
            }
        }
        model.addAttribute("result", result);
        return "result";
    }
}
