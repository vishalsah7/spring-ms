package com.glossy.userpackage.service.impl;

import com.glossy.userpackage.entity.User;
import com.glossy.userpackage.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

//@service annotation enables spring controller to understand that this is a service and can be autowired
@Service
public class UserServiceImpl implements UserService {

    //fake user list, you can fetch this from a db ideally.
    //todo : pull this from h2db or mysql
    List<User> userList = List.of(
            new User(1122L, "vishal", "74066410"),
            new User(1123L, "kajal", "763392"),
            new User(1124L, "papa", "9934")
    );

    @Override
    public User getUser(Long id) {
        return userList.stream().filter(user -> user.getUserId().equals(id)).findAny().orElse(null);
    }
}
