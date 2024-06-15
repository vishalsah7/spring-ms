package com.glossy.userpackage.entity;

import java.util.ArrayList;
import java.util.List;

public class User {

    private Long userId;
    private String name;
    private String phoneNum;

    List<Contact> contacts = new ArrayList<>();

    public User(Long userId, String name, String phoneNum, List<Contact> contacts) {
        this.userId = userId;
        this.name = name;
        this.phoneNum = phoneNum;
        this.contacts = contacts;
    }

    public User(Long userId, String name, String phoneNum) {
        this.userId = userId;
        this.name = name;
        this.phoneNum = phoneNum;
    }

    public User() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
