package com.example.model.service.impl;

import com.example.model.entity.QuestionType;
import com.example.model.repository.QuestionTypeRepository;
import com.example.model.service.IQuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionTypeService implements IQuestionTypeService {
    @Autowired
    QuestionTypeRepository questionTypeRepository;

    @Override
    public List<QuestionType> findAllList() {
        return questionTypeRepository.findAll();
    }

    @Override
    public Page<QuestionType> findAll(Pageable pageable) {
        return questionTypeRepository.findAll(pageable);
    }

    @Override
    public void save(QuestionType questionType) {
        questionTypeRepository.save(questionType);
    }

    @Override
    public Optional<QuestionType> findById(Long id) {
        return questionTypeRepository.findById(id);
    }
}
