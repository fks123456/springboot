package com.springboot.controller;

import com.springboot.model.Res;
import com.springboot.service.ResService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/res")
public class ResController {

    @Autowired
    private ResService resService;

    @RequestMapping("/save")
    @RequiresPermissions("res/save")
    public String save(Res res) {
        if(resService.save(res)) {
            return "保存成功";
        } else {
            return "保存失败";
        }
    }
}
