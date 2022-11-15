package com.example1.springjspdemo.dao;

import com.example1.springjspdemo.bean.User;

public interface UserDao {
    User getUserById(String userId);
    int createNewUser(User user);
}
