package com.controler;

import com.service.ConvertServiceImpl;
import com.service.IConvertService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {

    @Autowired
    IConvertService ConvertService;

    @GetMapping
    public String goHome() {
        return "home";
    }

    @PostMapping("abc")
    public String convert(@RequestParam double a, double b, double c, Model model) {
        double result = ConvertService.covert(a, b, c);
        model.addAttribute("result", result);
        return "home";
    }
}
