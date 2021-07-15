package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public String calculator(double numberOne, double numberTwo, String calculator) {
        String result = "" ;
        try {
            switch (calculator){
                case "+":
                    result = "Addition" +  (numberOne + numberTwo) ;
                    break;
                case "-":
                    result = "Subtraction" + (numberOne - numberTwo) ;
                    break;
                case "*":
                    result = "Multiplication" +(numberOne * numberTwo) ;
                    break;
                case "/":
                    result = "Division  " + (numberOne / numberTwo) ;
                    break;
            }
        }catch (Exception e){
            result = " Error " + e.getMessage();
        }

        return result ;
    }
}
