package com.flipzon.ecom;


import com.flipzon.ecom.controller.UserController;
import com.flipzon.ecom.entity.User;
import com.flipzon.ecom.repository.IUserService;
import com.flipzon.ecom.validator.BuyerRegistrationValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @InjectMocks
    @Autowired
    UserController userController;

    @Mock
    IUserService userService;

    private User createUserObject() {
        User user = new User();
        user.setAddress("TestUser");
        user.setEmailId("test@thoughtworks.com");
        user.setMobile("8095395188");
        user.setName("TestUser");
        user.setUserName("TestUserName");
        user.setDate(new Date());
        user.setUserName("TestName");
        user.setPassword("**********");
        return user;
    }

    @Test
    public void verfiyIfUserServiceIsCalled(){
       User user = createUserObject();
       user.setGender("male");
       userController.buyerRegistration(user);
       verify(userService,times(1)).addUser(user);

    }
    @Test
    public void shouldNotCallIfValidationFails(){
        User user = createUserObject();
        userController.buyerRegistration(user);
        verify(userService,times(0)).addUser(user);

    }
}
