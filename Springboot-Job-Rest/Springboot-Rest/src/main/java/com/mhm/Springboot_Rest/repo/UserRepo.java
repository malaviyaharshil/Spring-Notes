package com.mhm.Springboot_Rest.repo;

import com.mhm.Springboot_Rest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
    User findByName(String username);
}
