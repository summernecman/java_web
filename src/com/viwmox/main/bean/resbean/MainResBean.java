package com.viwmox.main.bean.resbean;

import java.io.Serializable;

/**
 * Created by SWSD on 2016-06-07.
 */
public class MainResBean implements Serializable{
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
