package com.example.model.repository.employee;


import com.example.model.entity.employee.Position;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPositionRepository extends PagingAndSortingRepository<Position, Integer> {
}
