package com.example.model.dto;

import com.example.model.entity.contract.AttachService;
import com.example.model.entity.contract.Contract;

import javax.validation.constraints.Min;

public class ContractDetailDto {
    private  Integer id;
//    @NotNull(message = "Pls input not null")
//    @NotBlank(message = "pls input not null")
    @Min(value = 0,message = "pls input min >0")
    private int quantity;

    private AttachService attachService;


    private Contract contract;

    public ContractDetailDto() {
    }

    public ContractDetailDto(Integer id, int quantity, AttachService attachService, Contract contract) {
        this.id = id;
        this.quantity = quantity;
        this.attachService = attachService;
        this.contract = contract;
    }

    public ContractDetailDto(int quantity, AttachService attachService, Contract contract) {
        this.quantity = quantity;
        this.attachService = attachService;
        this.contract = contract;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
