package com.flipzon.ecom.dao;

import com.flipzon.ecom.entity.User;

import java.util.List;

public interface UserDAO {
    boolean addUser(User user);

    List<User> getUser(String userName);

}

