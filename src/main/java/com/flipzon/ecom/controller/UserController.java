package com.flipzon.ecom.controller;

import com.flipzon.ecom.entity.User;
import com.flipzon.ecom.repository.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping(method = RequestMethod.POST,value = "/users")
    public ResponseEntity<?> buyerRegistration(@RequestBody User user){
        boolean flag = userService.addUser(user);
        return new ResponseEntity<User>(HttpStatus.CREATED);
    }
}
