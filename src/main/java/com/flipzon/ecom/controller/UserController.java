package com.flipzon.ecom.controller;

import com.flipzon.ecom.entity.User;
import com.flipzon.ecom.repository.IUserService;
import com.flipzon.ecom.validator.BuyerRegistrationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping(method = RequestMethod.POST,value = "/users")
    public ResponseEntity<String> buyerRegistration(@RequestBody User user){
        String message = BuyerRegistrationValidator.validateMandatoryFieldsInPayload(user);

        if (message.isEmpty()) {
            boolean flag = userService.addUser(user);
            return new ResponseEntity<String>(HttpStatus.CREATED);
        }
        else
            return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
    }
}
