package com.example.model.entity.employee;

import javax.persistence.*;
import java.util.List;

@Entity
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private String divisionName;

    @OneToMany(targetEntity = Employee.class)
    List<Employee> employees;

    public Division() {
    }

    public Division(String divisionName, List<Employee> employees) {
        this.divisionName = divisionName;
        this.employees = employees;
    }

    public Division(Integer id, String divisionName, List<Employee> employees) {
        this.id = id;
        this.divisionName = divisionName;
        this.employees = employees;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
