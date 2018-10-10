package com.springboot.controller;

import com.springboot.model.User;
import com.springboot.repository.UserRepository;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/save")
    public String save() {
        User user = new User();
        user.setName("fks");
        userService.save(user);
        return "保存成功";
    }

    @RequestMapping("/jpaSave")
    public User jpaSave() {
        User user = new User();
        user.setName("fks-jpa");
        user = userService.jpaSave(user);

        return user;
    }

    @RequestMapping("/findById/{id}")
    public User findById(@PathVariable Integer id) {
        User user = userService.findById(id);
        return user;
    }
}
