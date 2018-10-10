package com.springboot.controller;

import com.springboot.common.BaseResponse;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "用户管理")
@RestController
public class UserController {

    @ApiOperation(value = "登录接口",notes = "用户名-密码登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", paramType = "query", dataType = "string", required = false),
            @ApiImplicitParam(name = "password", value = "密码", paramType = "query", dataType = "string", required = false)
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "登陆成功"),
            @ApiResponse(code = 1, message = "用户名和密码不能为空"),
            @ApiResponse(code = 2, message = "用户名或密码错误")
    })
    @PostMapping("/login")
    public BaseResponse<String> login(String userName, String password) {
        BaseResponse<String> re = new BaseResponse<>();
        if(userName == null || password == null) {
            re.setCode("1");
            re.setMsg("用户名或密码不能为空");
        } else if (!"fks".equals(userName) || !"123456".equals(password)) {
            re.setCode("2");
            re.setMsg("用户名或密码错误");
        } else {
            re.setCode("0");
            re.setMsg("登陆成功");
            re.setData("user --> {userName: fks, password: 123456}");
        }
        return re;
    }
}
