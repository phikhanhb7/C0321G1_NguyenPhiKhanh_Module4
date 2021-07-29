package com.example.model.service;

import com.example.model.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    List<Customer> findAll();

    Optional<Customer> findById(Long id);

    void save(Customer customer);

    void delete(Long id);
}
