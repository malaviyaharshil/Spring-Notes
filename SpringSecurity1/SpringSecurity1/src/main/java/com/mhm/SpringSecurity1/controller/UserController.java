package com.mhm.SpringSecurity1.controller;

import com.mhm.SpringSecurity1.model.User;
import com.mhm.SpringSecurity1.service.JwtService;
import com.mhm.SpringSecurity1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.Authenticator;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticatorManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping("register")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PostMapping("login")
    public String loginUser(@RequestBody User user) {

        Authentication authentication = authenticatorManager.authenticate(new UsernamePasswordAuthenticationToken(user.getName(),user.getPassword()));

        if(authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getName());
//            return "success";
        } else {
            return "login failed";
        }
    }
}
