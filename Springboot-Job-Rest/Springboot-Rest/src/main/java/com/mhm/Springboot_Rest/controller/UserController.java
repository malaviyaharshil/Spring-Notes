package com.mhm.Springboot_Rest.controller;

import com.mhm.Springboot_Rest.model.User;
import com.mhm.Springboot_Rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("register")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
}
