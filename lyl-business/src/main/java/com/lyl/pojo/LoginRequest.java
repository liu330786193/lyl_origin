package com.lyl.pojo;

import java.io.Serializable;

/**
 * Created by lyl on 2017/4/25.
 */
public class LoginRequest implements Serializable {

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
