package com.example.model.entity.contract;

import javax.persistence.*;

@Entity
public class ContractTotal {
    @Id
    private  Integer id;
    private  String contractStartDay;
    private  String contractEndDay;
    private double contractDeposit;
    private String customerName;
    private double contractTotal;
    private boolean flag;
}
