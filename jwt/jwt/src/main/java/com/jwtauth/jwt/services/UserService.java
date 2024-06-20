package com.jwtauth.jwt.services;

import com.jwtauth.jwt.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    List<User> users = new ArrayList<>();

    public UserService() {
        users.add(new User(UUID.randomUUID().toString(), "vishal", "vishalsah7@gmail.com"));
        users.add(new User(UUID.randomUUID().toString(), "kajal", "kajalsah7@gmail.com"));
        users.add(new User(UUID.randomUUID().toString(), "rishi", "rishisah7@gmail.com"));
    }

    public List<User> getUsers(){
        return users;
    }
}
