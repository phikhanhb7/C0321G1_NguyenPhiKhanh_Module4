package com.example.model.repository.employee;

import com.example.model.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {

    @Query(value = "select * from employee  where concat(employee_name,employee_birthday) like %?1% " +
            " and flag =0  ", nativeQuery = true)
    Page<Employee> findAllByEmployeeNameContaining(String name,Pageable pageable);
}
