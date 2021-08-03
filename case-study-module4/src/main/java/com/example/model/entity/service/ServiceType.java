package com.example.model.entity.service;

import javax.persistence.*;
import java.util.List;

@Entity

public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private  String serviceTypeName;

    @OneToMany(targetEntity = Services.class)
    List<Services> services;

    public ServiceType() {
    }

    public ServiceType(Integer id, String serviceTypeName, List<Services> services) {
        this.id = id;
        this.serviceTypeName = serviceTypeName;
        this.services = services;
    }

    public ServiceType(String serviceTypeName, List<Services> services) {
        this.serviceTypeName = serviceTypeName;
        this.services = services;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }

    public List<Services> getServices() {
        return services;
    }

    public void setServices(List<Services> services) {
        this.services = services;
    }
}
