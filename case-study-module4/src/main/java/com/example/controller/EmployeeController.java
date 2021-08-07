package com.example.controller;

import com.example.model.dto.EmployeeDto;
import com.example.model.entity.employee.Division;
import com.example.model.entity.employee.EducationDegree;
import com.example.model.entity.employee.Employee;
import com.example.model.entity.employee.Position;
import com.example.model.service.employee.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;


    @ModelAttribute("divisionList")
    public Iterable<Division> getDivisionList(){
        return employeeService.findAllDivision();
    }
    @ModelAttribute("educationDegreeList")
    public Iterable<EducationDegree> getEducationDegreeList(){
        return employeeService.findAllEducationDegree();
    }
    @ModelAttribute("positionList")
    public Iterable<Position> getPositionList(){
        return employeeService.findAllPosition();
    }


    @GetMapping("")
    public String showListEmpoyee(@RequestParam Optional<String> search,
                                  @PageableDefault(value = 2) Pageable pageable,
                                  Model model){
        Page<Employee> employees = employeeService.findAllByEmployeeNameContaining(search.orElse(""),pageable);
        model.addAttribute("search",search.orElse(""));
        model.addAttribute("employees",employees);
        return "/employee/list";
    }

    @GetMapping(value = {"/create-employee"})
    public ModelAndView showCreateEmployee() {
        EmployeeDto employeeDto = new EmployeeDto();
        ModelAndView modelAndView = new ModelAndView("employee/create");
        modelAndView.addObject("employeeDto", employeeDto);
        return modelAndView;
    }

    @PostMapping(value = "/create-employee")
    public ModelAndView saveCEmployee(@Validated @ModelAttribute EmployeeDto employeeDto, BindingResult bindingResult) {

        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);

        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("/employee/create");
            modelAndView.addObject(bindingResult.getModel());
            return modelAndView;
        } else {
            employeeService.save(employee);
            ModelAndView modelAndView = new ModelAndView("/employee/create");
            modelAndView.addObject("employee", employee);
            modelAndView.addObject("mes", "new employee created successfully");
            return modelAndView;
        }

    }

//    @GetMapping("/create-employee")
//    public String showEditEmployee(Model model){
//        model.addAttribute("employeeDto",new EmployeeDto());
//        return "/employee/create";
//    }
//
//    @PostMapping("/create-employee")
//    public String editEmployee(@Validated @ModelAttribute("employeeDto") EmployeeDto employeeDto, Model model, BindingResult bindingResult){
//
//        if (bindingResult.hasFieldErrors()){
//            return "/employee/create";
//    }
//    Employee employee = new Employee();
//        BeanUtils.copyProperties(employeeDto,employee);
//        employeeService.save(employee);
//        model.addAttribute("mes","Create OK");
//        return "/employee/create";
//    }

    @GetMapping(value = "/edit-employee/{id}")
    public String showEditForm(@PathVariable Integer id, Model model){
        Optional<Employee> employee = employeeService.findById(id);
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee.get(),employeeDto);
        if (employee.isPresent()){
            model.addAttribute("employeeDto",employeeDto);
            return "/employee/edit";
        }else {
            return "/error";
        }
    }

    @PostMapping(value = "/edit-employee")
    public ModelAndView updateCustomer(@Validated @ModelAttribute EmployeeDto employeeDto,
                                       BindingResult bindingResult,RedirectAttributes redirectAttributes) {
       Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("/employee/edit");
            return modelAndView;
        } else {
            employeeService.save(employee);
            ModelAndView modelAndView = new ModelAndView("redirect:/employees");
            modelAndView.addObject("employee", employee);
            redirectAttributes.addFlashAttribute("mes", "Employee update successfully");
            return modelAndView;
        }

    }

    @GetMapping(value = "/delete-employee")
    public String deleteEmployee(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        Optional<Employee> employee = employeeService.findById(id);
        if (!employee.isPresent()) {
            return "/error";
        }
       employee.get().setFlag(true);
        employeeService.save(employee.get());
        redirectAttributes.addFlashAttribute("mes", "deleted successfully! ");
        return "redirect:/employees";
    }
}
