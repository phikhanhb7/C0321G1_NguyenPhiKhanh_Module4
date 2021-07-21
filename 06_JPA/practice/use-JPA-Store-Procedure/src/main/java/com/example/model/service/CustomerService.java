package com.example.model.service;

import com.example.model.bean.Customer;
import com.example.model.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public void insertWithStoredProcedure(Customer customer) {
         customerRepository.insertWithStoredProcedure(customer);
    }
}