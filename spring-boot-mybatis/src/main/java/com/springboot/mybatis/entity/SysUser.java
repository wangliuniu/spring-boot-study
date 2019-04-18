package com.springboot.mybatis.entity;

import lombok.Data;

@Data
public class SysUser {
    private long userId;
    private String mobile;
    private String password;
    private String username;
    private String avatar;
}
