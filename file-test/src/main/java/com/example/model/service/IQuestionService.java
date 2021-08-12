package com.example.model.service;

import com.example.model.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IQuestionService {
    Page<Question> findAllPage(String name , Pageable pageable);

    Optional<Question> findById(Long id);

    void save(Question question);

    Page<Question> findAllByQuestionType_Id(Long id, Pageable pageable);

    Page<Question> findAll(Pageable pageable);

    Page<Question> findAllByNameAndIdQuestionType(String name , String id , Pageable pageable);
}
