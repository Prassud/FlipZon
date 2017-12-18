package com.flipzon.ecom.repository;

import com.flipzon.ecom.dao.IUserDAO;
import com.flipzon.ecom.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserDAO userDAO;

    @Override
    public boolean addUser(User user) {
            userDAO.addUser(user);
        return true;
    }
}
