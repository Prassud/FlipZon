package com.flipzon.ecom.controller;

import com.flipzon.ecom.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @RequestMapping(method = RequestMethod.POST,value = "/users")
    public ResponseEntity<?> buyerRegistration(@RequestBody User user){
        return new ResponseEntity<User>(HttpStatus.CREATED);
    }
}
