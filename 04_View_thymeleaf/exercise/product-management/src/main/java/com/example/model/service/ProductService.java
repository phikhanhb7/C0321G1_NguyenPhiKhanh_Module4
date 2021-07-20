package com.example.model.service;

import com.example.model.bean.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService implements IProductService {
    private final static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Iphone 5", "50000", "99%", "Iphone"));
        products.put(2, new Product(2, "Iphone 6", "60000", "98%", "Iphone"));
        products.put(3, new Product(3, "Iphone 7", "70000", "100%", "Iphone"));
        products.put(4, new Product(4, "Iphone 8", "80000", "99%", "Iphone"));
        products.put(5, new Product(5, "Iphone 9", "90000", "99%", "Iphone"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void create(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void edit(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void delete(int id) {
        products.remove(id);
    }
}
