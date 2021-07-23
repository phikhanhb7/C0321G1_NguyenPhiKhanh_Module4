package com.example.controller;

import com.example.model.bean.Customer;
import com.example.model.bean.Province;
import com.example.model.service.ICustomerService;
import com.example.model.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.Optional;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @Autowired
    IProvinceService provinceService;

    @ModelAttribute("provinceList")
    public Iterable<Province> findAll(){
        return provinceService.findAll();
    }

    @RequestMapping("")
    public String goHome(@RequestParam("search") Optional<String> search,Model model , RedirectAttributes redirectAttributes, @PageableDefault(value = 3)Pageable pageable){
        Page<Customer> customers ;
        if (search.isPresent()){
            customers = customerService.findAllByFirstNameContaining(search.get(),pageable);
        }else {
            customers = customerService.findAll(pageable);
        }

        model.addAttribute("customers",customers);
        redirectAttributes.addFlashAttribute("message","");
        return "customer/home";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/create";
    }

    @PostMapping("/create")
    public String save(Customer customer, Model model, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("success", "Create Customer OK ");
        return "redirect:/customer";

    }

    // edit
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            model.addAttribute("customer", customer.get());
            return "customer/edit";

        } else {
            return "error.404" ;
        }
    }

    @PostMapping("/edit")
    public String update(Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("success", "Edit Customer OK");
        return "redirect:/customer";
    }

    // deltete
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.findById(id).get());
        return "customer/delete";
    }

    @PostMapping("/delete")
    public String delete(Customer customer, RedirectAttributes redirect) {
        customerService.remove(customer.getId());
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/customer";
    }

    //views
    @GetMapping("/{id}/view")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.findById(id).get());
        return "customer/view";
    }
}
