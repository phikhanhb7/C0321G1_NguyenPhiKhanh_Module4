package com.blog.model.service;

import com.blog.model.entity.Blog;
import com.blog.model.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    Page<Category> findAll(Pageable pageable);
    void save(Category category);
    List<Category> findAllList();
    Category findById(Long id);
    void remove(Long id);
}
