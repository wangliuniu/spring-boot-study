package com.springboot.mybatis.service.impl;

import com.springboot.mybatis.entity.Course;
import com.springboot.mybatis.entity.SysUser;
import com.springboot.mybatis.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserServiceImplTest {
    @Resource
    private SysUserService sysUserService;

    @Test
    public void selectAll() {
        List<SysUser> sysUserList = sysUserService.selectAll();
        sysUserList.forEach(sysUser -> System.out.println(sysUser));

    }

    @Test
    public void getOne() {
        SysUser sysUser = sysUserService.getOne(2L);
        System.out.println(sysUser);

    }

    @Test
    public void delete() {
        sysUserService.delete(3L);
    }

    @Test
    public void insert() {
        SysUser sysUser = new SysUser();
        sysUser.setMobile("13338613829");
        sysUser.setPassword("123456");
        sysUser.setUsername("玥玥");
        sysUser.setAvatar("user3.jpg");
        sysUserService.insert(sysUser);
    }
    @Test
    public void update(){
        SysUser sysUser=sysUserService.getOne(4L);
       sysUser.setAvatar("999.jpg");
        sysUser.setPassword("222222");
        sysUserService.update(sysUser);

}
}