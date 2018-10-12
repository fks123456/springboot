package com.springboot.controller;

import com.springboot.common.BaseResponse;
import com.springboot.model.User;
import com.springboot.service.UserService;
import com.springboot.util.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/save")
    @RequiresPermissions("user/save")
    public String save(User user) {

        if(user.getPassword() != null && !"".equals(user.getPassword().trim())) {
            user.setPassword(MD5Utils.encrypt(user.getPassword().trim()));
        }

        if(userService.save(user)) {
            return "保存成功";
        } else {
            return "保存失败";
        }
    }

    @RequestMapping("/isPermission")
    public boolean isPermission(String permission) {

        Subject subject = SecurityUtils.getSubject();

        return subject.isPermitted(permission);
    }

    @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();

        return "退出成功";
    }

    @RequestMapping("/login")
    public BaseResponse<User> login(String name, String password) {

        BaseResponse<User> baseResponse = new BaseResponse<>();

        if(name == null || password == null || "".equals(name.trim()) || "".equals(password.trim())) {
            baseResponse.setCode("1");
            baseResponse.setMsg("用户名和密码不能为空");
        } else {
            UsernamePasswordToken token = new UsernamePasswordToken(name.trim(), MD5Utils.encrypt(password.trim()));
            Subject subject = SecurityUtils.getSubject();

            try {
                subject.login(token);
                baseResponse.setCode("0");
                baseResponse.setMsg("登陆成功");
            } catch (IncorrectCredentialsException e) {
                baseResponse.setCode("2");
                baseResponse.setMsg("密码错误");
                e.printStackTrace();
            } catch (UnknownAccountException e) {
                baseResponse.setCode("3");
                baseResponse.setMsg("用户名不存在");
                e.printStackTrace();
            } catch (Exception e) {
                baseResponse.setCode("4");
                baseResponse.setMsg("登陆失败");
                e.printStackTrace();
            }
        }

        return baseResponse;
    }

}
