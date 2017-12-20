package com.flipzon.ecom.service;

import com.flipzon.ecom.dao.UserDAO;
import com.flipzon.ecom.entity.User;
import com.flipzon.ecom.repository.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
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
        user.setUserName("TestName");
        user.setPassword("**********");
        return user;
    }
    private User createBuyer() {
        User user = createUser();
        user.setDate(new Date());
        user.setUserType("BUYER");
        user.setGender("male");
        return user;
    }

    @Test
    public void verifyIfBuyerIsAddedSuccessfully(){
        User user = createBuyer();
        when(userDAO.addUser(user)).thenReturn(true);
        boolean flag = userService.addUser(user);
        Assert.assertEquals(true, flag);
        verify(userDAO, times(1)).addUser(user);


    }

    @Test
    public void shouldReturnFalseIfBuyerAddFails(){
        User user = createBuyer();
        when(userDAO.addUser(user)).thenReturn(false);
        boolean flag = userService.addUser(user);
        Assert.assertEquals(false, flag);
        verify(userDAO, times(1)).addUser(user);

    }


    private User createSeller() {
        User user = createUser();
        user.setExperience(10);
        user.setPanCard("BNLPA7869A");
        user.setUserType("SELLER");
        return user;
    }

    @Test
    public void verifyIfSellerIsAddedSuccessfully(){
        User user = createSeller();
        when(userDAO.addUser(user)).thenReturn(true);
        boolean flag = userService.addSeller(user);
        Assert.assertEquals(true, flag);
        verify(userDAO, times(1)).addUser(user);

    }


}
