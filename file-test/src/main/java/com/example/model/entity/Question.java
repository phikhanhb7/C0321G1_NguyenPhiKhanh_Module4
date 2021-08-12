package com.example.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String question;
    private String answer;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private QuestionType questionType;
    private String dateCreate;
    private String status;
    private boolean flag;
}
