package com.example.model.service;

import com.example.model.entity.User;
import com.example.model.repository.IUserRopository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    @Autowired
    IUserRopository userRopository;
    @Override
    public void save(User user) {
        userRopository.save(user);
    }
}
