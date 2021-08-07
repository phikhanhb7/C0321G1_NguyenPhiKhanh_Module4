package com.example.model.repository.user;


import com.example.model.entity.user.AppUser;
import com.example.model.entity.user.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    List<UserRole> findByAppUser(AppUser appUser);
}
