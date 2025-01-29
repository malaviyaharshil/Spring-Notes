package com.mhm.SpringSecurity1.dao;

import com.mhm.SpringSecurity1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
    User findByName(String username);
}
