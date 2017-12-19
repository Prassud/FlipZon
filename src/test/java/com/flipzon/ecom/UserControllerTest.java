package com.flipzon.ecom;


import com.flipzon.ecom.controller.UserController;
import com.flipzon.ecom.entity.User;
import com.flipzon.ecom.repository.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @Mock
    IUserService userService;

    @InjectMocks
    @Autowired
    UserController userController;

    @Test
    public void verfiyIfUserServiceIsCalled(){
        User user = mock(User.class);
        
    }
}
