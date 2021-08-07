package com.example.model.service.impl.customer;

import com.example.model.entity.customer.Customer;
import com.example.model.repository.customer.ICustomerRepository;
import com.example.model.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override

    public Iterable<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Integer id) {
       return iCustomerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
       iCustomerRepository.save(customer);
    }

    @Override
    public void remove(Integer id) {
        iCustomerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findByCustomerNameContaining(String name, Pageable pageable) {
        return this.iCustomerRepository.findByCustomerNameContaining(name ,pageable);
    }

}
