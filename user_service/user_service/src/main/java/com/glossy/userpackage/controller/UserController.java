package com.glossy.userpackage.controller;

import com.glossy.userpackage.entity.Contact;
import com.glossy.userpackage.entity.User;
import com.glossy.userpackage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    //todo : add preauthorize
    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") Long userId){
        List<Contact> contacts = restTemplate.getForObject("http://contact-service/contact/user/"+userId, List.class);
        User user = userService.getUser(userId);
        user.setContacts(contacts);
        return user;
    }
}
