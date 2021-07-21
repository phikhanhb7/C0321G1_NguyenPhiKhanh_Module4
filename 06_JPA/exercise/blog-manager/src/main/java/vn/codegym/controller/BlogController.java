package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.bean.Blog;
import vn.codegym.model.service.IBlogService;

@Controller
@RequestMapping(value = "/blog")
public class BlogController {
    @Autowired
    IBlogService blogService;


    @RequestMapping("")
    public String goHome(Model model , RedirectAttributes redirectAttributes){
        model.addAttribute("blogs",blogService.findAll());
        redirectAttributes.addFlashAttribute("message","");
        return "home";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        return "/create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute Blog blog , RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("success", "Create Blog OK ");
        return "redirect:/blog";

    }

    // edit
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("success", "Edit Blog OK");
        return "redirect:/blog";
    }

    // deltete
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Blog blog, RedirectAttributes redirect) {
        blogService.delete(blog);
        redirect.addFlashAttribute("success", "Removed Blog successfully!");
        return "redirect:/blog";
    }

    //views
    @GetMapping("/{id}/view")
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/view";
    }

}
