package com.example.controller;

import com.example.model.entity.Cart;
import com.example.model.entity.Product;
import com.example.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }


    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @SessionAttribute Cart cart, Model model) {
        Product productOptional = productService.findById(id);
        if (productOptional == null) {
            return "/error";
        }
        cart.addProduct(productOptional);
        model.addAttribute("msg", "Đã thêm sản phẩm vào giỏ hàng!!!");
        model.addAttribute("product", productOptional);
        return "/view";
    }

    @GetMapping("/view/{id}")
    public String viewProduct(@PathVariable Long id,
                              Model model) {
        Product productOptional = productService.findById(id);
        if (productOptional == null) {
            return "/error";
        }
        model.addAttribute("product", productOptional);
        return "/view";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id, @SessionAttribute Cart cart) {
        Product product = productService.findById(id);
        if (product == null) {
            return "/error";
        }
        cart.removeProduct(product);
        return "redirect:/cart";
    }

    @GetMapping("/change/{id}")
    public String changeCountProduct(@PathVariable Long id,
                                     @ModelAttribute Cart cart,
                                     @RequestParam("action") String action) {
        Product product = productService.findById(id);
        if (product == null) {
            return "/error";
        }
        cart.changeCount(product, action);
        return "redirect:/cart";
    }
}
