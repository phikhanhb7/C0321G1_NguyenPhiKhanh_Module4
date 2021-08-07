package com.example.model.service.impl.employee;

import com.example.model.entity.employee.Division;
import com.example.model.entity.employee.EducationDegree;
import com.example.model.entity.employee.Employee;
import com.example.model.entity.employee.Position;
import com.example.model.repository.employee.IDivisionRepository;
import com.example.model.repository.employee.IEducationDegreeRepository;
import com.example.model.repository.employee.IEmployeeRepository;
import com.example.model.repository.employee.IPositionRepository;
import com.example.model.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    IEmployeeRepository employeeRepository;

    @Autowired
    IDivisionRepository divisionRepository;

    @Autowired
    IEducationDegreeRepository educationDegreeRepository;

    @Autowired
    IPositionRepository positionRepository;

    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Iterable<Division> findAllDivision() {
        return divisionRepository.findAll();
    }

    @Override
    public Iterable<EducationDegree> findAllEducationDegree() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public Iterable<Position> findAllPosition() {
        return positionRepository.findAll();
    }

    @Override
    public Page<Employee> findAllByEmployeeNameContaining(String name, Pageable pageable) {
        return employeeRepository.findAllByEmployeeNameContaining(name,pageable);
    }


    @Override
    public Optional<Employee> findById(Integer id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void remove(Employee employee) {
        employeeRepository.delete(employee);
    }
}
