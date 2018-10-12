package com.springboot.service;

import com.springboot.model.User;

public interface UserService {
    public boolean save(User user);

    public User findByName(String name);
}
