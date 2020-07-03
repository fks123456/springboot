package com.fks.service.impl;

import com.fks.annotations.Master;
import com.fks.mapper.IUserMapper;
import com.fks.domain.User;
import com.fks.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserMapper userMapper;

    @Override
    @Transactional(readOnly = true)
    public List<User> selectAllUser() {
        return userMapper.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAllUser() {
        return userMapper.findAll();
    }
}
