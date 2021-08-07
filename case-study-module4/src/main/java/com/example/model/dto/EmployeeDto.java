package com.example.model.dto;

import com.example.model.entity.employee.Division;
import com.example.model.entity.employee.EducationDegree;
import com.example.model.entity.employee.Position;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private  Integer id;
    @NotNull(message = "input not null")
    @NotBlank
    private  String employeeName;
    @NotNull(message = "input not null")
    @NotBlank
    private  String employeeBirthday;
    @NotNull(message = "input not null")
    @Min(value = 0,message = "pls input value >0")
    private String employeeIdCard;
    @NotNull(message = "input not null")
    @Min(value = 0,message = "pls input value >0")
    private Double employeeSalary;
    @NotNull
    @Pattern(regexp = "^090\\d{7}|\\(84\\)\\+90\\d{7}|091\\d{7}|\\(84\\)\\+91\\d{7}$",message = "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")
    private  String employeePhone;
    @NotNull
    @Email
    private  String employeeEmail;
    @NotNull
    private String employeeAddress;
    private Division division;
    private Position position;
    private EducationDegree educationDegree;

}
