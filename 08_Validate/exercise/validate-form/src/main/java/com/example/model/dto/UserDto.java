package com.example.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private Long id;
    @NotBlank(message = "Pls Input")
    @Size(min = 5,max = 45,message = "Pls input between 5 and 45 characters")
    private String firstName;
    @NotBlank(message = "Pls input")
    @Size(min = 5,max = 45,message = "Pls input between 5 and 45 characters")
    private String lastName;
    @Pattern(regexp = "^[0-9]{10}$",message = "Pls input 10 number")
    private String numberPhone;
    @Min(18)
    @NotNull(message = "Pls Input")
    private Integer age;
}
