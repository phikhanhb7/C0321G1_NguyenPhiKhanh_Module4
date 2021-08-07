package com.example.model.dto;

import com.example.model.entity.contract.AttachService;
import com.example.model.entity.contract.Contract;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContractDetailDto {
    private  Integer id;

    @Min(value = 0,message = "pls input min >0")
    private int quantity;

    private AttachService attachService;


    private Contract contract;

}
