package com.flipzon.ecom.control;


import com.flipzon.ecom.controller.UserController;
import com.flipzon.ecom.entity.User;
import com.flipzon.ecom.repository.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @InjectMocks
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
        user.setPassword("TestPassword");
        user.setGender("Male");
        user.setUserType("BUYER");
        return user;
    }

    @Test
    public void shouldReturnStatusOkIfUserRegisteredSuccessfully() {
        User user = createUser();
        when(userService.addUser(user)).thenReturn(true);
        ResponseEntity<String> response = userController.userRegistration(user);
        Assert.assertEquals(HttpStatus.CREATED, response.getStatusCode());

    }

    @Test
    public void shouldReturnInternalServerErrorIfServiceFails() {
        User user = createUser();
        when(userService.addUser(any())).thenReturn(false);
        ResponseEntity<String> response = userController.userRegistration(user);
        Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());

    }


    @Test
    public void shouldReturnBadRequestIfUserValidationFails() {
        User user = createUser();
        user.setName("");
        ResponseEntity<String> response = userController.userRegistration(user);
        Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }


}
