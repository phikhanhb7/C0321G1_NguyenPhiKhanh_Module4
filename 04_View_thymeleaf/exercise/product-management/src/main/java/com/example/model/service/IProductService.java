package com.example.model.service;

import com.example.model.bean.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void create(Product product);

    Product findById(int id);

    void edit(int id, Product product);

    void delete(int id);
}
