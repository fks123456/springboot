package com.fks.service;

import com.fks.domain.User;

import java.util.List;

public interface IUserService {
    public List<User> selectAllUser();

    public List<User> findAllUser();
}
