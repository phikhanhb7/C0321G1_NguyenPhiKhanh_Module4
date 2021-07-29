package com.example.controller;

import com.example.model.dto.CustomerDto;
import com.example.model.entity.Customer;
import com.example.model.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer/api/v1")
public class CustomerController {

    @Autowired
    ICustomerService customerService;

    @PostMapping
    public ResponseEntity addCustomer(@RequestBody CustomerDto customerDto){
        Customer customer =new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        customerService.save(customer);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> showListCustomer(){
        List<Customer> customers = customerService.findAll();
        if (customers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> editCustomer(@PathVariable Long id,
                                                 @RequestBody CustomerDto customerDto){
        Optional<Customer> customer = customerService.findById(id);
        if (!customer.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customer.get().setFirstName(customerDto.getFirstName());
        customer.get().setLastName(customerDto.getFirstName());
        customerService.save(customer.get());
        return new ResponseEntity<>(customer.get(),HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    private ResponseEntity<Customer> deleteCustomer(@PathVariable Long id){
        Optional<Customer> customer = customerService.findById(id);
        if (!customer.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerService.findById(id);
        return new ResponseEntity<>(customer.get(),HttpStatus.OK);
    }
}
