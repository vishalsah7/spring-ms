package com.glossy.contact.controller;

import com.glossy.contact.entity.Contact;
import com.glossy.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/user/{userId}")
    public List<Contact> getContacts(@PathVariable("userId") Long userId){
        return contactService.getContactsOfaUser(userId);
    }
}