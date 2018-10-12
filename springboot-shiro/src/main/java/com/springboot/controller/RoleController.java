package com.springboot.controller;

import com.springboot.model.Role;
import com.springboot.service.RoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/save")
    @RequiresPermissions("role/save")
    public String save(Role role) {
        if(roleService.save(role)) {
            return "保存成功";
        } else {
            return "保存失败";
        }
    }
}
