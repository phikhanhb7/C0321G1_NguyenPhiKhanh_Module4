package com.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "please input")
    @Size(min = 2, max = 30, message = "nhập đún định dạng từ 2 đến 30 ký tự")
    private String name;
    @NotNull(message = "please input")
    @Min(value = 18, message = "tuổi lớn hơn 18")
    private Integer age;

}
