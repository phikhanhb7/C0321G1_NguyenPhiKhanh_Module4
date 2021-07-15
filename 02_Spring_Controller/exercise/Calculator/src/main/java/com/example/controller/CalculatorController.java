package com.example.controller;

import com.example.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    ICalculatorService calculatorService;

    @RequestMapping("/")
    public String goHome() {
        return "index";
    }

    @RequestMapping("/calculator")
    public String result(@RequestParam double numberOne, @RequestParam double numberTwo,@RequestParam String calculator, ModelMap modelMap) {
        String result = "";
        result = calculatorService.calculator(numberOne, numberTwo, calculator);
        modelMap.addAttribute("result", result);
        return "index";
    }
}
