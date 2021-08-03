package com.example.model.service.employee;

import com.example.model.entity.employee.Division;
import com.example.model.entity.employee.EducationDegree;
import com.example.model.entity.employee.Employee;
import com.example.model.entity.employee.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IEmployeeService {
    Iterable<Employee> findAll();

    Iterable<Division> findAllDivision();
    Iterable<EducationDegree> findAllEducationDegree();
    Iterable<Position> findAllPosition();

    Page<Employee> findAllByEmployeeNameContaining(String name, Pageable pageable);

    Optional<Employee> findById(Integer id);

    void save(Employee employee);

    void remove(Integer id);
}
