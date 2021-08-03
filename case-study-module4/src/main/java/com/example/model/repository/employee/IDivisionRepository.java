package com.example.model.repository.employee;

import com.example.model.entity.employee.Division;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDivisionRepository extends PagingAndSortingRepository<Division, Integer> {
}
