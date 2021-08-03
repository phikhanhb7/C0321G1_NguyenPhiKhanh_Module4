package com.example.model.service.customer;

import com.example.model.entity.customer.CustomerType;

public interface ICustomerTypeService {
    Iterable<CustomerType> findAll();
}
