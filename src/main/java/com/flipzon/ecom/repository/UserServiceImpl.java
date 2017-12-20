package com.flipzon.ecom.repository;

import com.flipzon.ecom.dao.UserDAO;
import com.flipzon.ecom.entity.User;
import com.flipzon.ecom.entity.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public boolean addUser(User user) {
        updateUserBasendUserType(user);
        encryptPassword(user);
        return userDAO.addUser(user);
    }

    private void updateUserBasendUserType(User user) {
        if (UserType.BUYER.toString().equals(user.getUserType())) {
            user.setPanCard(null);
            user.setExperience(null);
        } else {
            user.setGender(null);
            user.setDate(null);
        }
    }

    @Override
    public List<User> getUser(String userName) {
        return userDAO.getUser(userName);
    }

    private void encryptPassword(User user) {
        user.setPassword(Base64.getEncoder().encodeToString(user.getPassword().getBytes()));
    }
}
