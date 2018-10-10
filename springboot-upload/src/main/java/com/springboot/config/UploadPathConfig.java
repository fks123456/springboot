package com.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UploadPathConfig {
    @Value("${uplodPath}")
    private String uplodPath;

    public String getUplodPath() {
        return uplodPath;
    }
}
