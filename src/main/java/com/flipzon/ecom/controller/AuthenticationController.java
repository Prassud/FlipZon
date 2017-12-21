package com.flipzon.ecom.controller;

import com.flipzon.ecom.entity.Credentials;
import com.flipzon.ecom.entity.User;
import com.flipzon.ecom.repository.UserService;
import com.flipzon.ecom.validator.CredentialsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.List;

@RestController
public class AuthenticationController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST,value = "/auth")
    public ResponseEntity authenticate(@RequestBody  Credentials credentials){

        String message = CredentialsValidator.validateUserCredentials(credentials);

        if(!message.isEmpty()) {
            return new ResponseEntity(message, HttpStatus.BAD_REQUEST);
        }

        List<User> users = userService.getUser(credentials.getUserName());


        if(users.size() > 0 && validatePassword(users.get(0), credentials))
            return new ResponseEntity(HttpStatus.ACCEPTED);
        else
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
    }

    private boolean validatePassword(User user, Credentials credentials) {
        if(credentials.getPassword() != null) {
            String encodedPassword = Base64.getEncoder().encodeToString(credentials.getPassword().getBytes());
            return user.getPassword().equals(encodedPassword);
        }
        return false;
    }
}
