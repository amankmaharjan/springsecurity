package com.example.CRUDDemo.controller;

import com.example.CRUDDemo.domain.User;
import com.example.CRUDDemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by aman on 6/14/17.
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user/")
    public ResponseEntity<?> display() {
        List<User> userList = userService.findAll();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<?> insert(@RequestBody User user) {
        userService.insert(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody User user) {
        userService.update(id, user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/user/{name}")
    public ResponseEntity<?> displayByName(@PathVariable String name) {
        User user = userService.findByname(name);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
