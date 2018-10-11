package com.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {

    @Value("${spring.servlet.multipart.location}")
    private String uplodPath;

    @RequestMapping("/index")
    public String index() {
        return "/index.html";
    }

    @RequestMapping("/upload")
    public @ResponseBody String upload(@RequestParam("img") MultipartFile file, HttpServletRequest request) {

        if(!file.isEmpty()) {
            String originalFilename = file.getOriginalFilename();
            String suffix = "";
            if(originalFilename.lastIndexOf(".") != -1) {
                suffix = "." + originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            }
            String name = System.currentTimeMillis() + suffix;
            File img = new File(uplodPath, name);
            if(!img.getParentFile().exists()) {
                img.getParentFile().mkdir();
            }
            try {
                file.transferTo(img);
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败";
            }
            return "上传成功";
        } else {
            return "上传失败，上传文件为空";
        }
    }
}
