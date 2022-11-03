package com.example.sprsecurity.service;

import com.example.sprsecurity.entity.User;
import com.example.sprsecurity.model.UserModel;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User saveUser(UserModel userModel);
}
