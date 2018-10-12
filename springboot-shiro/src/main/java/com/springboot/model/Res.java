package com.springboot.model;

import java.io.Serializable;

public class Res implements Serializable {
    private Integer id;
    private String resName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }
}
