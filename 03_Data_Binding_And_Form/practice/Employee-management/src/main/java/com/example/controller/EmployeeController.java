package com.example.controller;

import com.example.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @GetMapping("/show-form")
    public String showForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee/create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute("employee") Employee employee , Model model){
        model.addAttribute("id",employee.getId());
        model.addAttribute("name",employee.getName());
        model.addAttribute("contactNumber",employee.getContactNumber());
        return "employee/infor";
    }


}
