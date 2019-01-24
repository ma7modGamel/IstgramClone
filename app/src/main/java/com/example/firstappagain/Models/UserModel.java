package com.example.firstappagain.Models;

public class UserModel {

    public UserModel() {
    }

    private String name;
    private String email;
    private String phone;
    private String id_user;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public UserModel(String name, String email, String phone, String id_user) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.id_user = id_user;
    }

}
