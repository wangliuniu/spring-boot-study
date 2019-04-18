package com.springboot.mybatis.service;

import com.springboot.mybatis.entity.SysUser;

import java.util.List;

public interface SysUserService {
    List<SysUser> selectAll();
    SysUser getOne(long userId);
    void delete(long userId);
    void insert(SysUser sysUser);
    void update(SysUser sysUser);



}
