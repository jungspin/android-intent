package com.cos.viewtest1;

import java.io.Serializable;

// DB -> model
// 통신 -> DTO
// 자료형 -> 클래스 자료형
public class User implements Serializable {

    private int id;
    private String username;
    private String password;

    public User(){}

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
