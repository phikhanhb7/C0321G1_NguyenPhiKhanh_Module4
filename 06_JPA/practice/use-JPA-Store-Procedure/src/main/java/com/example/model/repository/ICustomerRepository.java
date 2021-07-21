package com.example.model.repository;

import com.example.model.bean.Customer;

public interface ICustomerRepository {
    void insertWithStoredProcedure(Customer customer);
}
