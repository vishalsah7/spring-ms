package com.jwtauth.jwt.controller;

import com.jwtauth.jwt.models.User;
import com.jwtauth.jwt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/home")
public class Home {

    @Autowired
    private UserService userService;


    public String welcome(){
        String test = "authenticated users access only";
        return test;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/current-user")
    public String getCurrentUser(Principal principal){
        return principal.getName();
    }
}
