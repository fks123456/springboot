package com.springboot.service;

import com.springboot.model.Res;

import java.util.List;

public interface ResService {
    public boolean save(Res res);
    public List<String> findAllResNameByRoleId(Integer id);
}
