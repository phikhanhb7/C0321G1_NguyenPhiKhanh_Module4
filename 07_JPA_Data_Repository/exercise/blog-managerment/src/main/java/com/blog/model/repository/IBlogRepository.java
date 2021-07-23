package com.blog.model.repository;

import com.blog.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends JpaRepository<Blog ,Long> {


    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findAllByAuthorContaining(String nameS, Pageable pageable);


    Page<Blog> findAllByOrderByDateDesc(Pageable pageable);

    Page<Blog> findAllByCategory_Id(Long id,Pageable pageable);

}
