package com.example.controller;

import com.example.model.entity.employee.Division;
import com.example.model.entity.employee.EducationDegree;
import com.example.model.entity.employee.Employee;
import com.example.model.entity.employee.Position;
import com.example.model.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
