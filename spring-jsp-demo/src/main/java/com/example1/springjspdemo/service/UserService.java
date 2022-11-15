package com.example1.springjspdemo.service;

import com.example1.springjspdemo.bean.User;

public interface UserService {
    User getUserByUserId(String userId);
    int createNewUser(User user);

}
