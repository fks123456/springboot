package com.springboot.service.impl;

import com.springboot.dao.ResMapper;
import com.springboot.model.Res;
import com.springboot.service.ResService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResServiceImpl implements ResService {

    @Autowired
    private ResMapper resMapper;

    @Override
    public boolean save(Res res) {

        return resMapper.save(res) > 0;
    }

    @Override
    public List<String> findAllResNameByRoleId(Integer id) {
        return resMapper.findAllResNameByRoleId(id);
    }
}
