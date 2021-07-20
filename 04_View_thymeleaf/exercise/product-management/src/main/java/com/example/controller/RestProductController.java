package com.example.controller;

import com.example.model.bean.Product;
import com.example.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class RestProductController {

    @Autowired
    IProductService productService;

    @GetMapping("")
    @ResponseBody
    public List<Product> getListProduct() {
        return productService.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<String> save(@RequestBody  Product product) {
        product.setId((int) (Math.random() * 10000));
        productService.create(product);
        return new ResponseEntity<>("Thanh cong", HttpStatus.OK);
    }
}
