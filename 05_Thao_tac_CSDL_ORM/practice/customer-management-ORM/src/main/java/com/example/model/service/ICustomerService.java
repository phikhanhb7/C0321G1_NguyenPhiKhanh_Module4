package com.example.model.service;

import com.example.model.bean.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(Integer id);
}
