package com.example.model.service;


import com.example.model.bean.Province;

import java.util.Optional;

public interface IProvinceService {
    Iterable<Province> findAll();

    Optional<Province> findById(Long id);

    void save(Province province);

    void remove(Long id);
}
