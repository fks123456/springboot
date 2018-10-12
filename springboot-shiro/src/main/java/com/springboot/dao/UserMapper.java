package com.springboot.dao;

import com.springboot.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public int save(User user);

    public List<User> findByName(String name);
}
