package com.springboot.service.impl;

import com.springboot.dao.UserMapper;
import com.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import com.springboot.service.UserService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Override
    public List<User> findAll() {

        redisTemplate.setKeySerializer(new StringRedisSerializer());

        List<User> users = (List<User>) redisTemplate.opsForValue().get("users");

        if(users == null) {
            System.out.println("===========================");
            System.out.println("执行了数据库查询");
            System.out.println("===========================");
            users = userMapper.findAll();
            redisTemplate.opsForValue().set("users", users);
        }

        return users;
    }

    @Override
    public int save(User user) {
        int count = userMapper.save(user);
        if(count > 0) {
            if(redisTemplate.hasKey("users")) {
                redisTemplate.delete("users");
            }
        }
        return count;
    }
}
