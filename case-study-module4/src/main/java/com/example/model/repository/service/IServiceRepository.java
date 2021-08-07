package com.example.model.repository.service;

import com.example.model.entity.service.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceRepository extends JpaRepository<Services,Integer> {
    @Query(value="select * from services where flag =0", nativeQuery = true,
            countQuery= "select count(*) from services where flag =0 ")
    Page<Services> findAll(Pageable pageable);
}
