package com.example.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
