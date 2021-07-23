package com.blog.controller;

import com.blog.model.entity.Blog;
import com.blog.model.service.IBlogService;
import com.blog.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.Optional;

@Controller
@RequestMapping({"", "/blog"})
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping({"/", "/search"})
    public ModelAndView showListBlog(@RequestParam(value = "nameS",required = false) Optional<String> nameS,
                                     @RequestParam(value = "searchId",required = false) Long search,
                                     @PageableDefault(value = 3) Pageable pageable) {
        Page<Blog> blogList;

        ModelAndView modelAndView = new ModelAndView("/blog/list");
        if (nameS.isPresent()) {
            blogList = blogService.searchByName(nameS.get(), pageable);
            modelAndView.addObject("nameS", nameS.get());
        } else if (search != null){
            blogList = blogService.findAllByCategory_Id(search,pageable);
        }else {
            blogList = blogService.findAllByOrderByDateDesc(pageable);
        }
        modelAndView.addObject("blogList", blogList);
        modelAndView.addObject("categoryList", categoryService.findAllList());

        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        return new ModelAndView("/blog/create", "blog", new Blog()).
                addObject("categoryList", categoryService.findAllList());
    }

    @PostMapping("/create")
    public ModelAndView saveBlog(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return new ModelAndView("/blog/create", "blog", blog).
                addObject("message", "Create is success").
                addObject("categoryList", categoryService.findAllList());
    }

    @GetMapping("/edit")
    public ModelAndView showEditForm(@RequestParam Long id) {
        Blog blog = blogService.findById(id);
        if (blog != null) {
            return new ModelAndView("/blog/edit", "blog", blog).
                    addObject("categoryList", categoryService.findAllList());
        } else {
            return new ModelAndView("/error-404");
        }
    }

    @PostMapping("/edit")
    public ModelAndView editBlog(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return new ModelAndView("/blog/edit", "blog", blog)
                .addObject("message", "edit is success").
                addObject("categoryList", categoryService.findAllList());
    }

    @GetMapping("/delete")
    public ModelAndView showDeleteForm(@RequestParam Long id) {
        Blog blog = blogService.findById(id);
        if (blog != null) {
            return new ModelAndView("/blog/delete", "blog", blog);
        } else {
            return new ModelAndView("/error-404");
        }
    }

    @PostMapping("/delete")
    public String deleteBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.remove(blog.getId());
        redirectAttributes.addFlashAttribute("message", "delete is success");
        return "redirect:/blog/";
    }
}