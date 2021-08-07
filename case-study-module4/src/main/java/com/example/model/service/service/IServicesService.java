package com.example.model.service.service;

import com.example.model.entity.service.RentType;
import com.example.model.entity.service.ServiceType;
import com.example.model.entity.service.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IServicesService {
    Iterable<RentType> findAllRentType();

    Iterable<ServiceType> findAllServiceType();

    Page<Services> findAll(Pageable pageable);

    Iterable<Services> findAll();

    void save(Services services);

    Optional<Services> findById(Integer id);
}
