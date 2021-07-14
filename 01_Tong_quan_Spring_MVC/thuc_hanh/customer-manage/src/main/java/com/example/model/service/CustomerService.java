package com.example.model.service;

import com.example.model.bean.Customer;
import com.example.model.repository.CustomerRepository;
import com.example.model.repository.ICustomerRepository;

import java.util.List;

public class CustomerService implements ICustomerService {
    ICustomerRepository repository = new CustomerRepository();

    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }
}
