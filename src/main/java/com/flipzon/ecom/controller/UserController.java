package com.flipzon.ecom.controller;

import com.flipzon.ecom.entity.User;
import com.flipzon.ecom.repository.UserService;
import com.flipzon.ecom.validator.BuyerRegistrationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST,value = "/users")
    public ResponseEntity<String> buyerRegistration(@RequestBody User user){
        String message = BuyerRegistrationValidator.validateBuyer(user);

        if (message.isEmpty()) {
            boolean flag = userService.addUser(user);
            if (flag)
            return new ResponseEntity<>(HttpStatus.CREATED);
            else
                return new ResponseEntity<>("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);

        }
        else
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}
