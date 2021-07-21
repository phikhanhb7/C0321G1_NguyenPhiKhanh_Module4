package com.example.model.service;

import com.example.model.bean.Customer;

public interface ICustomerService {
    void insertWithStoredProcedure(Customer customer);
}