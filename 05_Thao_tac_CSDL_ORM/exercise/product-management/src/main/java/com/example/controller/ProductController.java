package com.example.controller;

import com.example.model.bean.Product;
import com.example.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    IProductService productService;

    @GetMapping("")
    public String goHome(Model model, RedirectAttributes redirectAttributes) {
        model.addAttribute("products", productService.findAll());
        redirectAttributes.addFlashAttribute("success", "");
        return "home";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/create")
    public String save(Product product, Model model, RedirectAttributes redirectAttributes) {
        productService.create(product);
         redirectAttributes.addFlashAttribute("success", "Create Product OK ");
         return "redirect:/product";

    }

    // edit
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String update(Product product, RedirectAttributes redirectAttributes) {
        productService.edit(product);
        redirectAttributes.addFlashAttribute("success", "Edit Product OK");
        return "redirect:/product";
    }

    // deltete
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        productService.delete(product.getId());
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/product";
    }

    //views
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/view";
    }

}
