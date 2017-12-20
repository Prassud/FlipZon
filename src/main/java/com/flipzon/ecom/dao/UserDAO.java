package com.flipzon.ecom.dao;

import com.flipzon.ecom.entity.User;
import com.flipzon.ecom.entity.UserType;

public interface UserDAO {
    boolean addUser(User user);

    UserType getUserType(String userType);
}

