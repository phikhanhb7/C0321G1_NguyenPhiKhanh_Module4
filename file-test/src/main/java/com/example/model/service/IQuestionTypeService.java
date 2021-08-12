package com.example.model.service;

import com.example.model.entity.QuestionType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IQuestionTypeService {
        List<QuestionType> findAllList();

        Page<QuestionType> findAll(Pageable pageable);

        void save(QuestionType questionType);

        Optional<QuestionType> findById(Long id);
}
