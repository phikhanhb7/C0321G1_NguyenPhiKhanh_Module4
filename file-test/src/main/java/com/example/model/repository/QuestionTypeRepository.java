package com.example.model.repository;

import com.example.model.entity.QuestionType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionTypeRepository extends JpaRepository<QuestionType,Long> {
    @Query(value = " select * from question_type where flag = false",nativeQuery = true,
            countQuery = "select  count(*) from  question_type where flag =0")
    Page<QuestionType> findAll(Pageable pageable);
}
