package com.example.model.service.impl.service;

import com.example.model.entity.service.RentType;
import com.example.model.entity.service.ServiceType;
import com.example.model.entity.service.Services;
import com.example.model.repository.service.IRentTypeRepository;
import com.example.model.repository.service.IServiceRepository;
import com.example.model.repository.service.IServiceTypeRepository;
import com.example.model.service.service.IServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicesService implements IServicesService {
    @Autowired
    IServiceRepository serviceRepository;

    @Autowired
    IRentTypeRepository rentTypeRepository;

    @Autowired
    IServiceTypeRepository serviceTypeRepository;

    @Override
    public Iterable<RentType> findAllRentType() {
        return rentTypeRepository.findAll();
    }

    @Override
    public Iterable<ServiceType> findAllServiceType() {
        return serviceTypeRepository.findAll();
    }

    @Override
    public Page<Services> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public Iterable<Services> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public void save(Services services) {
        serviceRepository.save(services);
    }

    @Override
    public Optional<Services> findById(Integer id) {
        return serviceRepository.findById(id);
    }
}
