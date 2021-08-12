package com.example.model.dto;

import com.example.model.entity.QuestionType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
public class QuestionDto {

    private Long id;
    @NotBlank(message = "Pls input")
    @Size(min = 5 ,max = 100 , message = " Title nằm trong khoảng 5 đến 100 kí tự")
    private String title;
    @NotBlank(message = "Pls input")
    @Size(min = 10 , max= 500 , message = " Nội dung từ 10 đến 500 ký tự")
    private String question;
    private String answer;
    private QuestionType questionType;
    private String dateCreate = LocalDate.now().toString();
    private String status = "Chưa phản hồi";
    private boolean flag;
}
