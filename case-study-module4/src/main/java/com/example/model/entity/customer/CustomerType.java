package com.example.model.entity.customer;

import javax.persistence.*;
import java.util.List;

@Entity
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String customerTypeName;
    @OneToMany(targetEntity = Customer.class)
    private List<Customer> customers;

    public CustomerType() {
    }

    public CustomerType(String customerTypeName, List<Customer> customers) {
        this.customerTypeName = customerTypeName;
        this.customers = customers;
    }

    public CustomerType(Integer id, String customerTypeName, List<Customer> customers) {
        this.id = id;
        this.customerTypeName = customerTypeName;
        this.customers = customers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
