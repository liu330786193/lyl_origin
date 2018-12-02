package com.lyl.pojo;

import com.lyl.util.Excel.annotation.ExcelColumn;

public class User {

    @ExcelColumn(value = "编号")
    private Integer id;

    @ExcelColumn(value = "用户名")
    private String username;

    @ExcelColumn(value = "密码")
    private String password;

    @ExcelColumn(value = "状态")
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}