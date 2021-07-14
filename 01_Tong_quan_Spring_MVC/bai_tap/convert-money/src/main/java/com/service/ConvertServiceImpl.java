package com.service;

import org.springframework.stereotype.Service;

@Service
public class ConvertServiceImpl implements IConvertService {
    @Override
    public double covert(double a, double b, double c) {
        return a*c/b;
    }
}
