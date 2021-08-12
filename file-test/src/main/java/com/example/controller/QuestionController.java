package com.example.controller;

import com.example.model.dto.QuestionDto;
import com.example.model.entity.Question;
import com.example.model.entity.QuestionType;
import com.example.model.service.IQuestionService;
import com.example.model.service.IQuestionTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    IQuestionService questionService;

    @Autowired
    IQuestionTypeService questionTypeService;

    @ModelAttribute("questionTypeList")
    public List<QuestionType> getListQuestionType(){
        return questionTypeService.findAllList();
    }

    @GetMapping("")
    public String goPageQuestion(@PageableDefault(value = 3) Pageable pageable,
                                 @RequestParam("name")Optional<String> name ,
                                 @RequestParam("id") Optional<String> id,
                                 Model model){
        Page<Question> questionPage = questionService.findAllByNameAndIdQuestionType(name.orElse(""),
                                                                                    id.orElse(""),pageable);
        model.addAttribute("nameSearch",name.orElse(""));
        model.addAttribute("idSearch",id.orElse(""));
//        Page<Question>  questionPage = null ;
//        if (name.isPresent() && id.isPresent()){
//            questionPage = questionService.findAllByNameAndIdQuestionType(name.get(),id.get(),pageable);
//            model.addAttribute("nameSearch", name.get());
//            model.addAttribute("idSearch",id.get());
//        }else if (name.isPresent()  && !id.isPresent()){
//            questionPage = questionService.findAllPage(name.get(),pageable);
//            model.addAttribute("nameSearch", name.get());
//        }else if (id.isPresent() && !name.isPresent()){
//            questionPage = questionService.findAllByQuestionType_Id(id.get(),pageable);
//            model.addAttribute("idSearch",id.get());
//        }else if (!name.isPresent()&& !id.isPresent()){
//            questionPage = questionService.findAll(pageable);
//        }
        model.addAttribute("questionList", questionPage);
        return "/list";
    }


    @GetMapping("/create-question")
    public String showCreate(Model model){
        model.addAttribute("questionDto", new QuestionDto());
        return "/create";
    }

    @PostMapping("/create-question")
    public String createQuestion(@Valid @ModelAttribute("questionDto") QuestionDto questionDto , BindingResult bindingResult,
                                 Model model, RedirectAttributes redirectAttributes){
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("questionDto",questionDto);
            return "/create";
        }
        Question question = new Question();
        BeanUtils.copyProperties(questionDto,question);
        questionService.save(question);
        redirectAttributes.addFlashAttribute("mes","Create successful " + question.getTitle());
        return "redirect:/question";
    }

    @GetMapping("/edit-question/{id}")
    public String showEditQuestion(@PathVariable("id") Long id, Model model){
        Optional<Question> question = questionService.findById(id);
        if (!question.isPresent()){
            return "error";
        }
        QuestionDto questionDto = new QuestionDto();
        BeanUtils.copyProperties(question.get(),questionDto);
        model.addAttribute("questionDto",questionDto);
        return "/edit";
    }

    @PostMapping("/edit-question")
    public String editQuestion(@Valid @ModelAttribute("questionDto") QuestionDto questionDto, BindingResult bindingResult,
                               Model model, RedirectAttributes redirectAttributes){
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("questionDto",questionDto);
            return "/edit";
        }
        Question question = new Question();
        BeanUtils.copyProperties(questionDto,question);
        redirectAttributes.addFlashAttribute("mes","Edit successful " + question.getTitle());
        return "redirect:/question";
    }

    @GetMapping("/delete-question")
    public String deleteQuestion(@RequestParam("id") Long id, Model model){
        Optional<Question> question = questionService.findById(id);
        if (!question.isPresent()){
            return "/error";
        }
        question.get().setFlag(true);
        questionService.save(question.get());
        return "redirect:/question";
    }


}
