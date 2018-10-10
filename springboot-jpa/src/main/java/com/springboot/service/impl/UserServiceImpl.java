package com.springboot.service.impl;

import com.springboot.model.User;
import com.springboot.repository.UserJpaRepository;
import com.springboot.repository.UserRepository;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Override
    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public User jpaSave(User user) {
        user = userJpaRepository.save(user);
        return user;
    }

    @Override
    public User findById(Integer id) {
        User user = userJpaRepository.aa(id);
        return user;
    }


}
