package com.blog.controller;

import com.blog.model.entity.Blog;
import com.blog.model.entity.Category;
import com.blog.model.service.IBlogService;
import com.blog.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class RestBlogController {
    @Autowired
    IBlogService blogService;

    @Autowired
    ICategoryService categoryService;

    //Xem danh sách các category
    @GetMapping(value = "/category")
    public ResponseEntity<List<Category>> getListCategory(){
        List<Category> categories= categoryService.findAllList();
        if (categories.isEmpty()){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }
        return  new ResponseEntity<>(categories,HttpStatus.OK);
    }
    //    Xem danh sách các bài viết
    @GetMapping(value = "/blog")
    public ResponseEntity<List<Blog>> getListBlog(){
        List<Blog> blogs= blogService.findAll();
        if (blogs.isEmpty()){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }
        return  new ResponseEntity<>(blogs,HttpStatus.OK);
    }


//    Xem danh sách các bài viết của một category

    @GetMapping(value = "/blog-category/{id}")
    public ResponseEntity<List<Blog>> getCategoryOfBlog(@PathVariable Long id){
        List<Blog> blogs= blogService.findListBlogByCategory_Id(id);
        if (blogs.isEmpty()){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        return  new ResponseEntity<>(blogs,HttpStatus.OK);
    }

    //Xem chi tiết một bài viết
    @GetMapping(value = "/detail-blog/{id}")
    public ResponseEntity<Blog> getInfoBlog(@PathVariable Long id){
        Blog blog=this.blogService.findById(id);
        if (blog==null){
            return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }
}
