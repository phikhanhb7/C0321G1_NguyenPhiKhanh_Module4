package com.example.model.dto;

import com.example.model.entity.customer.CustomerType;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CustomerDto {
    private Integer id;
    @NotBlank
//    @UniqueElements
    @Pattern(regexp ="^(KH-)[0-9]{4}$", message = "Pls input code correct format. Ex : KH-XXXX")
    private String customerCode;
    private CustomerType customerType;
    @NotNull(message = "input not null")
    @NotBlank
    private String customerName;
    @NotNull(message = "input not null")
    private String customerBirthDay;
    private String customerGender;
    @Pattern(regexp = "^[0-9]{10}", message = " pls input correct format !")
    private String customerIdCard;
    @NotNull
    @Pattern(regexp = "^[0-9]{10}")
    private String customerPhone;
    @NotBlank(message = "pls input email")
    @Email(message = "Pls input correct format")
    private String customerEmail;
    private String customerAddress;


    public CustomerDto() {
    }

    public CustomerDto(String customerCode, CustomerType customerType, String customerName, String customerBirthDay,
                       String customerGender, String customerIdCard, String customerPhone, String customerEmail, String customerAddress) {
        this.customerCode = customerCode;
        this.customerType = customerType;
        this.customerName = customerName;
        this.customerBirthDay = customerBirthDay;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
    }

    public CustomerDto(Integer id, String customerCode, CustomerType customerType, String customerName, String customerBirthDay, String customerGender,
                       String customerIdCard, String customerPhone, String customerEmail, String customerAddress) {
        this.id = id;
        this.customerCode = customerCode;
        this.customerType = customerType;
        this.customerName = customerName;
        this.customerBirthDay = customerBirthDay;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthDay() {
        return customerBirthDay;
    }

    public void setCustomerBirthDay(String customerBirthDay) {
        this.customerBirthDay = customerBirthDay;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
//    @Override
//    public void validate(Object target, Errors errors) {
//        CustomerDto customerDto= (CustomerDto) target;
//        if (customerDto.email.equals("")){
//            errors.rejectValue("email","email.valid");
//        }
//
//    }
}
