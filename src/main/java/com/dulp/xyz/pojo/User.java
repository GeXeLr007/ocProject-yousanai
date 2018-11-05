package com.dulp.xyz.pojo;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class User {
    private String id;

    @NotNull
    private String username;

    @NotNull
    @Length(min = 6)
    private String password;

    @NotNull
    private String openId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }
}