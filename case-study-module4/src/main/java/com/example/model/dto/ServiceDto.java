package com.example.model.dto;

import com.example.model.entity.service.RentType;
import com.example.model.entity.service.ServiceType;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ServiceDto {
    private  Integer id;
    @NotNull(message = "input not null")
    @NotBlank
    private  String serviceName;
    @Pattern(regexp = "^(DV-)[0-9]{4}$",message = "Ex:DV-1111")
    @NotNull(message = "pls input not null")
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
    private String standardRoom;
    private String descriptionOtherConvenience;

    @NotNull(message = "input not null")
    @Min(value = 0,message = "pls input value >0")
    private  double poolArea;

    @NotNull(message = "input not null")
    @Min(value = 0,message = "pls input value >0")
    private int numberOfFloors;
    private ServiceType serviceType;
    private RentType rentType;

    public ServiceDto() {
    }

    public ServiceDto(Integer id, String serviceName, String serviceCode, int serviceArea, double serviceCost, int serviceMaxPeople, String standardRoom,
                      String descriptionOtherConvenience, double poolArea, int numberOfFloors, ServiceType serviceType, RentType rentType) {
        this.id = id;
        this.serviceName = serviceName;
        this.serviceCode = serviceCode;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.serviceType = serviceType;
        this.rentType = rentType;
    }

    public ServiceDto(String serviceName, String serviceCode, int serviceArea, double serviceCost, int serviceMaxPeople,
                      String standardRoom, String descriptionOtherConvenience, double poolArea, int numberOfFloors, ServiceType serviceType, RentType rentType) {
        this.serviceName = serviceName;
        this.serviceCode = serviceCode;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.serviceType = serviceType;
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public int getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(int serviceArea) {
        this.serviceArea = serviceArea;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public int getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(int serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
}
