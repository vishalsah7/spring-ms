package com.glossy.userpackage.entity;

public class Contact {

    private Long contactId;
    private Long userId;
    private String name;
    private String email;

    public Contact(Long contactId, Long userId, String name, String email) {
        this.contactId = contactId;
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    public Contact() {
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
