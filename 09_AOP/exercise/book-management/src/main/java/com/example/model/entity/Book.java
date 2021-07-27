package com.example.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book {
    @Id
    private Long id;
    private String name;
    private Integer quantity;
    private String author;
    private Date publicationDate;
}
