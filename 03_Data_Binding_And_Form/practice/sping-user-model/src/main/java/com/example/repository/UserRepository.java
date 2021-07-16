package com.example.repository;

import com.example.model.Login;
import com.example.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class UserRepository implements IUserRepository {

    private static List<User> users;
    static {
        users = new ArrayList<>();
        User u1 = new User();
        u1.setAge(10);
        u1.setName("John");
        u1.setAccount("john");
        u1.setEmail("john@codegym.vn");
        u1.setPassword("123456");
        users.add(u1);

        User u2 = new User();
        u2.setAge(15);
        u2.setName("Bill");
        u2.setAccount("bill");
        u2.setEmail("bill@codegym.vn");
        u2.setPassword("123456");
        users.add(u2);

        User u3 = new User();
        u3.setAge(16);
        u3.setName("Mike");
        u3.setAccount("mike");
        u3.setEmail("mike@codegym.vn");
        u3.setPassword("123456");
        users.add(u3);
    }
    @Override
    public User checkLogin(Login login) {
        for (User item : users){
            if ((item.getAccount().equals(login.getAccount())) & (item.getPassword().equals(login.getPassword()))){
                return item ;
            }
        }
        return null;
    }
}
