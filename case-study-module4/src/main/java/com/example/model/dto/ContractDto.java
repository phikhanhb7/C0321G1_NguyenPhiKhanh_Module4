package com.example.model.dto;

import com.example.model.entity.contract.ContractDetail;
import com.example.model.entity.customer.Customer;
import com.example.model.entity.employee.Employee;
import com.example.model.entity.service.Services;
import lombok.*;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContractDto implements Validator {
    private  Integer id;
    @NotBlank(message = "Pls input")
    private  String contractStartDay;
    @NotBlank(message = "Pls input")
    private  String contractEndDay;
    @NotNull(message = "input not null")
    @Min(value = 0,message = "pls input value >0")
    private double contractDeposit;
    @NotNull(message = "input not null")
    @Min(value = 0,message = "pls input value >0")
    private double contractTotal;

    private List<ContractDetail> contractDetails;

    private Services service;

    private Employee employee;

    private Customer customer;


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDto contractDto = (ContractDto) target;

        try {

            if (contractDto.contractStartDay.equals("")){
                errors.rejectValue("contractStartDay", "contractStartDay.valid", "Pls input");
            }
            if (contractDto.contractEndDay.equals("")){
                errors.rejectValue("contractEndDay", "contractEndDay.valid", "Pls input");
            }
            else {
                Date sDate = new SimpleDateFormat("yyyy-MM-dd").parse(contractDto.contractStartDay);
                Date eDate= new SimpleDateFormat("yyyy-MM-dd").parse(contractDto.contractEndDay);
                if (eDate.getTime()<sDate.getTime()){
                    errors.rejectValue("contractEndDay", "endDate.valid", "End date must be more start date");
                }
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
