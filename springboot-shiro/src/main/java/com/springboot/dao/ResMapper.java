package com.springboot.dao;

import com.springboot.model.Res;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ResMapper {
    public int save(Res res);

    public List<String> findAllResNameByRoleId(Integer id);
}
