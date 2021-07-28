package com.example.model.service;


import com.example.model.entity.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Product findById(Long id);
}