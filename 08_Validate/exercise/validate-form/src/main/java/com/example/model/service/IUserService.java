package com.example.model.service;

import com.example.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserService {
   void save(User user);
}
