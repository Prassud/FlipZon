package com.flipzon.ecom.repository;

import com.flipzon.ecom.entity.User;

import java.util.List;

public interface UserService
{
    boolean addUser(User user);
    List<User> getUser(String userName);



}
