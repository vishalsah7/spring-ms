package com.glossy.contact.service.impl;

import com.glossy.contact.entity.Contact;
import com.glossy.contact.service.ContactService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

    //fake list of contacts
    //todo: pull this from db

    List<Contact> listOfContactsOfaUser = List.of(
            new Contact(1L,1122L,"vishal","visah@visa.com"),
            new Contact(2L,1122L,"vishal","visahlsah@visa.com"),
            new Contact(3L,1122L,"vishal","visahlsah7@visa.com"),
            new Contact(4L,1123L,"kajal","trisha@visa.com"),
            new Contact(5L,1123L,"kajal","kajal@visa.com"),
            new Contact(6L,1124L,"kajal","trishasah@visa.com"),
            new Contact(7L,1124L,"papa","papa@visa.com")
    );

    @Override
    public List<Contact> getContactsOfaUser(Long userId) {
        return listOfContactsOfaUser.stream().filter( contact -> contact.getUserId().equals(userId)).collect(Collectors.toList());
    }
}
