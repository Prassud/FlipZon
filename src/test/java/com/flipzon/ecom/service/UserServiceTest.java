package com.flipzon.ecom.service;

import com.flipzon.ecom.dao.UserDAO;
import com.flipzon.ecom.dao.UserDAOImpl;
import com.flipzon.ecom.entity.User;
import com.flipzon.ecom.repository.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    @Autowired
    UserServiceImpl userService;

    @Mock
    private UserDAO userDAO;

    private User createUser() {
        User user = new User();
        user.setAddress("TestUser");
        user.setEmailId("test@thoughtworks.com");
        user.setMobile("8095395188");
        user.setName("TestUser");
        user.setUserName("TestUserName");
        user.setDate(new Date());
        user.setUserName("TestName");
        user.setPassword("**********");
        user.setGender("male");
        user.setUserType("BUYER");
        return user;
    }

    @Test
    public void verifyIfAddUserServiceIsSuccess(){
        User user = createUser();
        when(userDAO.addUser(any())).thenReturn(true);
        boolean flag = userService.addUser(user);
        Assert.assertEquals(true, flag);

    }

    @Test
    public void shouldReturnFalseIfUserAddFails(){
        User user = createUser();
        when(userDAO.addUser(any())).thenReturn(false);
        boolean flag = userService.addUser(user);
        Assert.assertEquals(false, flag);

    }


}
