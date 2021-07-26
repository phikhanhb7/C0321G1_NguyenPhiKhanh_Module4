package com.example.model.repository;

import com.example.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRopository extends JpaRepository<User,Long> {
}
