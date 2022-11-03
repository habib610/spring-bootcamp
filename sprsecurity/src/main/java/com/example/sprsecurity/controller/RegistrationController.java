package com.example.sprsecurity.controller;

import com.example.sprsecurity.entity.User;
import com.example.sprsecurity.model.UserModel;
import com.example.sprsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    @Autowired
    private UserService userService;
    @GetMapping(path = "/registration")
    public String saveUser(@RequestBody UserModel userModel){
        User user = userService.saveUser(userModel);
        return "Registration Success";
    }
}
