package com.springboot.service;

import com.springboot.model.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();

    public int save(User user);
}
