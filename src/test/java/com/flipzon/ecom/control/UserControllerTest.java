package com.flipzon.ecom.control;


import com.flipzon.ecom.controller.UserController;
import com.flipzon.ecom.entity.User;
import com.flipzon.ecom.repository.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import java.util.Date;


@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @InjectMocks
    @Autowired
    UserController userController;

    @Mock
    UserService userService;

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
    public void verifyBuyerRegistered(){
        User user = createUser();
        when(userService.addUser(any())).thenReturn(true);
        ResponseEntity<String> response = userController.buyerRegistration(user);
        Assert.assertEquals(HttpStatus.CREATED, response.getStatusCode());

    }
    @Test
    public void shouldReturnInternalServerErrorIfServiceFails(){
        User user = createUser();
        when(userService.addUser(any())).thenReturn(false);
        ResponseEntity<String> response = userController.buyerRegistration(user);
        Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());

    }
    @Test
    public void verifyBuyerNotRegisteredIfValidationFails(){
        User user = createUser();
        user.setName("");
        ResponseEntity<String> response = userController.buyerRegistration(user);
        Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
}