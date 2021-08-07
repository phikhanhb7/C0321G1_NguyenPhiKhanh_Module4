package com.example.model.service.customer;

import com.example.model.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface ICustomerService {
    Iterable<Customer> findAll();

    Page<Customer> findByCustomerNameContaining(String name , Pageable pageable);

    Optional<Customer> findById(Integer id);

    void save(Customer customer);

    void remove (Integer id);
}
