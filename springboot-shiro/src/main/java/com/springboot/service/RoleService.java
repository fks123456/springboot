package com.springboot.service;

import com.springboot.model.Role;

public interface RoleService {
    public boolean save(Role role);
    public Role findById(Integer id);
}
