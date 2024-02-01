package com.amita.user.service.controllers;

import com.amita.user.service.entities.User;
import com.amita.user.service.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private Service service;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){//requestbody used to receive all data in Json format
        User user1 = service.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId){
        User user = service.getUser(userId);
        return  ResponseEntity.ok(user);
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){//khali becuase we are not getting anything from user will send all userlist
           List<User> allUser = service.getAllUser();
           return ResponseEntity.ok(allUser);
    }

}
