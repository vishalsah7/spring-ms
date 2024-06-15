package com.glossy.contact.service;

import com.glossy.contact.entity.Contact;

import java.util.List;

public interface ContactService {

    public List<Contact> getContactsOfaUser(Long userId);
}
