package com.example.model.entity.employee;

import javax.persistence.*;
import java.util.List;

@Entity
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String educationDegreeName;

    @OneToMany(targetEntity = Employee.class)
    List<Employee> employees;

    public EducationDegree() {
    }

    public EducationDegree(Integer id, String educationDegreeName, List<Employee> employees) {
        this.id = id;
        this.educationDegreeName = educationDegreeName;
        this.employees = employees;
    }

    public EducationDegree(String educationDegreeName, List<Employee> employees) {
        this.educationDegreeName = educationDegreeName;
        this.employees = employees;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEducationDegreeName() {
        return educationDegreeName;
    }

    public void setEducationDegreeName(String educationDegreeName) {
        this.educationDegreeName = educationDegreeName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
