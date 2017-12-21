package com.flipzon.ecom.control;

import com.flipzon.ecom.controller.AuthenticationController;
import com.flipzon.ecom.controller.UserController;
import com.flipzon.ecom.entity.Credentials;
import com.flipzon.ecom.repository.UserService;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class AuthenticationControllerTest {
    @InjectMocks
    AuthenticationController authenticationController;

    @Mock
    UserService userService;

    private Credentials createCredentials() {
        Credentials credentials = new Credentials();
        credentials.setUserName("Agni");
        credentials.setPassword("password");
        return credentials;
    }

    @Test
    public void shouldReturnStatusOKOnValidUserNameAndPassword() {
    
    }
}
