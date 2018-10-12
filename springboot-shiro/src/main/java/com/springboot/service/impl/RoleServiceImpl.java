package com.springboot.service.impl;

import com.springboot.dao.RoleMapper;
import com.springboot.model.Role;
import com.springboot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public boolean save(Role role) {
        return roleMapper.save(role) > 0;
    }

    @Override
    public Role findById(Integer id) {
        return roleMapper.findById(id);
    }
}
