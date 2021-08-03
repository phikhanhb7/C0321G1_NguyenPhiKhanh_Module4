package com.example.model.service.impl.customer;

import com.example.model.entity.customer.CustomerType;
import com.example.model.repository.customer.ICustomerTypeRepository;
import com.example.model.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerTypeServiceImpl implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository customerTypeRepository;
    @Override

    public Iterable<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }

}
