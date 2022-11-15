package com.example1.springjspdemo.service.impl;

import com.example1.springjspdemo.bean.User;
import com.example1.springjspdemo.dao.UserDao;
import com.example1.springjspdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Override
    public User getUserByUserId(String userId)
    {
        User user = userDao.getUserById(userId);
        return user;
    }

    @Override
    public int createNewUser(User user) {
        return userDao.createNewUser(user);
    }

}
