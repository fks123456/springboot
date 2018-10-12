package com.springboot.dao;

import com.springboot.model.Role;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper {
    public int save(Role role);

    public Role findById(Integer id);
}
