package vn.codegym.model.service;

import vn.codegym.model.bean.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    void delete(Blog blog);

    Blog findById(Integer id);

}
