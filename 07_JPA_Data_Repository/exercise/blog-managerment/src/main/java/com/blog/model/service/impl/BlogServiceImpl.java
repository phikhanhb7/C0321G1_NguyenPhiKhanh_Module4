package com.blog.model.service.impl;

import com.blog.model.entity.Blog;
import com.blog.model.repository.IBlogRepository;
import com.blog.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;


    @Override
    public Page<Blog> findAll(Pageable pageable) {

        return blogRepository.findAll(pageable);
    }

    @Override
    public Blog findById(Long id)   {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        blog.setDate(LocalDate.now().toString());
        blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> searchByName(String nameS, Pageable pageable) {
        Page<Blog> blogPage=blogRepository.findAllByAuthorContaining(nameS,pageable);
        return blogPage;
    }

    @Override
    public Page<Blog> findAllByOrderByDateDesc(Pageable pageable) {
        return blogRepository.findAllByOrderByDateDesc(pageable);
    }



}
