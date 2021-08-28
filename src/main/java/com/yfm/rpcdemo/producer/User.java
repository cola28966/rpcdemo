package com.yfm.rpcdemo.producer;

import java.io.Serializable;

/**
 * @Author yangFangMin
 * @Date 2021/8/28
 * @Todo
 */
public class User implements Serializable {

    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
