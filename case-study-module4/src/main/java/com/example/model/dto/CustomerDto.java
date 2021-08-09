package com.example.model.dto;

import com.example.model.entity.customer.CustomerType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {   //implements Validator
//
//    public final String PHONE_NUMBER="^(090|091|(\\(84\\)\\+90)|(\\(84\\)\\+91))[0-9]{7}$";
//    public final String NAME="^[\\p{L} .'-]+$";
//    public final String DATE="^((2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26])))-02-29)$"
//            + "|^(((19|2[0-9])[0-9]{2})-02-(0[1-9]|1[0-9]|2[0-8]))$"
//            + "|^(((19|2[0-9])[0-9]{2})-(0[13578]|10|12)-(0[1-9]|[12][0-9]|3[01]))$"
//            + "|^(((19|2[0-9])[0-9]{2})-(0[469]|11)-(0[1-9]|[12][0-9]|30))$";
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
    @Pattern(regexp = "^090\\d{7}|\\(84\\)\\+90\\d{7}|091\\d{7}|\\(84\\)\\+91\\d{7}$",message = "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")
    private String customerPhone;
    @NotBlank(message = "pls input email")
    @Email(message = "Pls input correct format")
    private String customerEmail;
    private String customerAddress;


//    @Override
//    public boolean supports(Class<?> clazz) {
//        return false;
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        CustomerDto customerDto = (CustomerDto) target;
//        if (!customerDto.customerCode.matches("^KH-[0-9]{4}$")){
//            errors.rejectValue("customerCode", "customerCode.format");
//        }
//        if (!customerDto.customerPhone.matches(PHONE_NUMBER)){
//            errors.rejectValue("customerPhone", "customerPhone.format");
//        }
//        if (!customerDto.customerBirthday.matches(DATE)){
//            errors.rejectValue("customerBirthday", "customerBirthday.format");
//        }
//        if (!customerDto.customerIdCard.matches("^[0-9]{9}$|^[0-9]{12}$")){
//            errors.rejectValue("customerIdCard", "customerIdCard.format");
//        }
//    }
}
