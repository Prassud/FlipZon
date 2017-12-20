package com.flipzon.ecom.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "User_Type")
public class UserType {
    @Column(name = "id")
    private int id;

    @Column(name = "user_type")
    public String getUserTypeValue() {
        return userTypeValue;
    }

    public void setUserTypeValue(String userTypeValue) {
        this.userTypeValue = userTypeValue;
    }

    @Column(name = "user_type")
    private String userTypeValue;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
