package com.service;

public class ConvertServiceImpl implements IConvertService {
    @Override
    public double covert(double a, double b, double c) {
        return a*c/b;
    }
}
