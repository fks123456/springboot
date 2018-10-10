package com.springboot.service;

import com.springboot.model.User;

public interface UserService {
    public void save(User user);
    public User jpaSave(User user);
    public User findById(Integer id);
}
