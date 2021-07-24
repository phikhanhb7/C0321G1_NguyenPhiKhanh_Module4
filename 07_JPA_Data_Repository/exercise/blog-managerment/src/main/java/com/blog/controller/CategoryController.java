package com.blog.controller;
import com.blog.model.entity.Blog;
import com.blog.model.entity.Category;
import com.blog.model.service.IBlogService;
import com.blog.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;

    @Autowired
    IBlogService blogService;

    @GetMapping("")
    public ModelAndView showList(@PageableDefault(value = 2) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("/category/list");
        modelAndView.addObject("categoryList",categoryService.findAll(pageable));
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        return new ModelAndView("/category/create","category",new Category());
    }

    @PostMapping("/create")
    public ModelAndView saveBlog(@ModelAttribute Category category) {
        categoryService.save(category);
        return new ModelAndView("/category/create", "category", category).addObject("message", "Create is success");
    }

    @GetMapping("/edit")
    public ModelAndView showEditForm(@RequestParam Long id) {
        Category category = categoryService.findById(id);
            return new ModelAndView("/category/edit", "category", category);
    }

    @PostMapping("/edit")
    public ModelAndView editBlog(@ModelAttribute Category category) {
        categoryService.save(category);
        return new ModelAndView("/category/edit", "category", category)
                .addObject("message", "edit is success");

    }

    @GetMapping("/delete")
    public ModelAndView showDeleteForm(@RequestParam Long id) {
        Category category = categoryService.findById(id);
        if (category != null) {
            return new ModelAndView("/category/delete", "category", category);
        } else {
            return new ModelAndView("/error-404");
        }
    }

    @PostMapping("/delete")
    public String deleteBlog(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        categoryService.remove(category.getId());
        redirectAttributes.addFlashAttribute("message", "delete is success");
        return "redirect:/category";
    }

    @GetMapping("/view")
    public String showView(@RequestParam Long id, Model model,Pageable pageable){
        Page<Blog> blogs = blogService.findAllByCategory_Id(id,pageable);
        model.addAttribute("blogList",blogs);
        return "/category/view";
    }

}