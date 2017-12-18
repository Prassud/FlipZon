package com.flipzon.ecom.entity;

import java.util.Date;


public class User {
    private String name;
    private String emailId;
    private String userName;
    private String password;
    private String address;
    private String mobile;
    private String gender;
    private Date date;

    public String getName() {
        return name;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getMobile() {
        return mobile;
    }

    public String getGender() {
        return gender;
    }

    public Date getDate() {
        return date;
    }
}
