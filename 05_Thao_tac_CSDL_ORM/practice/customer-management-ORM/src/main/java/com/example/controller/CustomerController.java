package com.example.controller;

import com.example.model.bean.Customer;
import com.example.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @GetMapping("")
    public String comeList(Model model){
        model.addAttribute("customerList",customerService.findAll());
        return "list";
    }

    @GetMapping(value = "/detail")
    public String goDetailStudent(@RequestParam Integer id, Model model) {
        model.addAttribute("customer",
                this.customerService.findById(id));

        return "detail";
    }

    @RequestMapping("/create")
    public String goCreate(Model model){
        model.addAttribute("customer",new Customer());
        return "create";
    }

    @PostMapping("/create")
    public String createCustomer(Customer customer){
        customerService.save(customer);
        return "redirect:/customer";
    }

}
