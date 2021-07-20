package com.example.model.repository;

import com.example.model.bean.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();

    void save(Customer customer);

     Customer findById(Integer id);
}
