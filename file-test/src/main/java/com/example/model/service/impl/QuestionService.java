package com.example.model.service.impl;

import com.example.model.entity.Question;
import com.example.model.repository.QuestionRepository;
import com.example.model.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService implements IQuestionService {

    @Autowired
    QuestionRepository questionRepository;


//    @Override
//    public Page<Question> findAllPage(String name, Pageable pageable) {
//        return questionRepository.findAllPage(name, pageable);
//    }

    @Override
    public Page<Question> findAllPage(String name, Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Question> findById(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    public void save(Question question) {
        questionRepository.save(question);
    }

    @Override
    public Page<Question> findAllByQuestionType_Id(Long id, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Question> findAll(Pageable pageable) {
        return null;
    }

//    @Override
//    public Page<Question> findAllByQuestionType_Id(Long id, Pageable pageable) {
//        return questionRepository.findAllByQuestionType_Id(id,pageable);
//    }
//
//    @Override
//    public Page<Question> findAll(Pageable pageable) {
//        return questionRepository.findAll(pageable);
//    }

    @Override
    public Page<Question> findAllByNameAndIdQuestionType(String name, String id, Pageable pageable) {
        return questionRepository.findAllByNameAndIdQuestionType(name,id,pageable);
    }


}
