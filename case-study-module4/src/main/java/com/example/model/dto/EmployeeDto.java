package com.example.model.dto;

import com.example.model.entity.employee.Division;
import com.example.model.entity.employee.EducationDegree;
import com.example.model.entity.employee.Position;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto implements Validator {
    private  Integer id;
    @NotNull(message = "input not null")
    @NotBlank(message = "Pls input")
    private  String employeeName;
    @NotNull(message = "input not null")
    @NotBlank(message = "Pls input")
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
    @Email(message = "Pls input")
    private  String employeeEmail;
    @NotBlank(message = "Pls input")
    private String employeeAddress;
    private Division division;
    private Position position;
    private EducationDegree educationDegree;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
            EmployeeDto employeeDto= (EmployeeDto) target;
        if (employeeDto.employeeBirthday.equals("")){
            errors.rejectValue("employeeBirthday","","Pls input");
        }else {
            int age = Period.between(LocalDate.parse(employeeDto.employeeBirthday),LocalDate.now()).getYears();
            if (age < 18) {
                errors.rejectValue("employeeBirthday", "", "Age must be more than 18");
            }else if (age > 150){
                errors.rejectValue("employeeBirthday", "", "You DIE");
            }
        }
    }
}
