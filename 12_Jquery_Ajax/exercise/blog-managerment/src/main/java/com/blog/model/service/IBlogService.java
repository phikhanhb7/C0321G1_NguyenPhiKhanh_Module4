package com.blog.model.service;

import com.blog.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);
    List<Blog> findAll();
    Blog findById(Long id);
    void save(Blog blog);
    void remove(Long id);
    Page<Blog> searchByName(String nameS, Pageable pageable);
    Page<Blog> findAllByOrderByDateDesc(Pageable pageable);

    Page<Blog> findAllByCategory_Id(Long id,Pageable pageable);
    List<Blog> findAllByAuthorContaining(String nameS);
}
