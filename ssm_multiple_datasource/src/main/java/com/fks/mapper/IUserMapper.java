package com.fks.mapper;

import com.fks.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper
@Repository
public interface IUserMapper {
    public List<User> findAll();
}
