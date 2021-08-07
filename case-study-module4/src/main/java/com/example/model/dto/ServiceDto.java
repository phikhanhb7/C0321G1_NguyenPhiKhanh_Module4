package com.example.model.dto;

import com.example.model.entity.service.RentType;
import com.example.model.entity.service.ServiceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceDto {
    private  Integer id;
    @NotNull(message = "input not null")
    @NotBlank
    private  String serviceName;
    @Pattern(regexp = "^(DV-)[0-9]{4}$",message = "Ex:DV-1111")
    @NotNull(message = "pls input not null")
    @NotBlank
    private  String serviceCode;

    @NotNull(message = "input not null")
    @Min(value = 0,message = "pls input value >0")
    private int serviceArea;

    @NotNull(message = "input not null")
    @Min(value = 0,message = "pls input value >0")
    private double serviceCost;

    @NotNull(message = "input not null")
    @Min(value = 0,message = "pls input value >0")
    private int serviceMaxPeople;
    @NotBlank
    @NotNull(message = "input not null")
    private String standardRoom;
    @NotBlank
    @NotNull(message = "input not null")
    private String descriptionOtherConvenience;

    @NotNull(message = "input not null")
    @Min(value = 0,message = "pls input value >0")
    private  double poolArea;

    @NotNull(message = "input not null")
    @Min(value = 0,message = "pls input value >0")
    private int numberOfFloors;
    private ServiceType serviceType;
    private RentType rentType;
}
