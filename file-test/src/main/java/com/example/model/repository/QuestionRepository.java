package com.example.model.repository;

import com.example.model.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {
    @Query(value = " select * from question where question.title like %?1% and question.question_type_id like %?2% and flag = 0 order by question.status asc, date_create desc ", nativeQuery = true,
            countQuery = "select count(*) from question where question.title like %?1% and question.question_type_id like %?2% and flag = 0 order by question.status asc, date_create desc")
    Page<Question> findAllByNameAndIdQuestionType(String name, String id, Pageable pageable);

//    Page<Question> findAllByQuestionType_Id(Long id, Pageable pageable);
//
//    Page<Question> findAll(Pageable pageable);
//
//    @Query(value = " select * from question " +
//            "join question_type where question.flag = 0 and (question.title like %?1% and question_type.id like %?2%)", nativeQuery = true,
//            countQuery = "select count(*) from question " +
//                    "join question_type " +
//                    "on question.question_type_id = question_type.id " +
//                    "where question.flag = 0 and (question.title like %?1% and question_type.id like %?2%)")
//    Page<Question> findAllByNameAndIdQuestionType(String name , Long id , Pageable pageable);
//}
}
