package com.example.controller;


import com.example.model.bean.Customer;
import com.example.model.service.CustomerService;
import com.example.model.service.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {
    private ICustomerService service = new CustomerService() ;

@GetMapping("/customers")
    public ModelAndView listCustomer(){
    List<Customer> customers = service.findAll();
    ModelAndView modelAndView = new ModelAndView("customers/list","customers",customers);
    return  modelAndView;
    }

}
