package com.example.tabuto.keepfit.model.User;

import com.google.gson.annotations.SerializedName;

public class User {

    private String name;
    private String email;
    private String gender;
    private String age;
    private String password;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }
}
