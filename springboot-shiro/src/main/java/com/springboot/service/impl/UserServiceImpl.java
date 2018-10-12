package com.springboot.service.impl;

import com.springboot.dao.UserMapper;
import com.springboot.model.User;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean save(User user) {

        return userMapper.save(user) > 0;
    }

    @Override
    public User findByName(String name) {
        List<User> users = userMapper.findByName(name);
        return users.size() == 0 ? null : users.get(0);
    }
}
