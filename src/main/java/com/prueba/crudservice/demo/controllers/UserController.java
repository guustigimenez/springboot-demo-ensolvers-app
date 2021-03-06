package com.prueba.crudservice.demo.controllers;

import com.prueba.crudservice.demo.models.User;
import com.prueba.crudservice.demo.models.dtos.LoginDTO;
import com.prueba.crudservice.demo.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    private ResponseEntity<User> addUser(@RequestBody User user){
        return ResponseEntity.ok(userService.addUser(user));
    }

    @GetMapping("/login")
    private ResponseEntity<?> login(@RequestBody LoginDTO userData){
        return ResponseEntity.ok(userService.login(userData));
    }

}
