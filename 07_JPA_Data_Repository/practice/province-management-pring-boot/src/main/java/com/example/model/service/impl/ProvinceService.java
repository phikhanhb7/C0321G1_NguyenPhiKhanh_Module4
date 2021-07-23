package com.example.model.service.impl;

import com.example.model.bean.Province;
import com.example.model.repository.IProvinceRepository;
import com.example.model.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.Optional;



@Service
public class ProvinceService implements IProvinceService {
    @Autowired
    IProvinceRepository provinceRepository;


    @Override
    public Iterable<Province> findAll() {
        return provinceRepository.findAll();
    }


    @Override
    public Optional<Province> findById(Long id) {
        return provinceRepository.findById(id);
    }

    @Transactional
    @Override
    public void save(Province province) {
        provinceRepository.save(province);
    }

    @Transactional
    @Override
    public void remove(Long id) {
        provinceRepository.deleteById(id);
    }
}
