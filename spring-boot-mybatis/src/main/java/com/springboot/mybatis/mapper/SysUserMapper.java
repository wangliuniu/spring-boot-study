package com.springboot.mybatis.mapper;

import com.springboot.mybatis.entity.Course;
import com.springboot.mybatis.entity.SysUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SysUserMapper {
    @Results({
            @Result(column = "user_id", property = "userId"),
            @Result(column = "mobile", property = "mobile"),
            @Result(column = "password", property = "password"),
            @Result(column = "username", property = "username"),
            @Result(column = "avatar", property = "avatar"),

    })
    @Select("SELECT * FROM t_sys_user ")
    List<SysUser> selectAll();


    @Results({
            @Result(column = "user_id", property = "userId"),
            @Result(column = "mobile", property = "mobile"),
            @Result(column = "password", property = "password"),
            @Result(column = "username", property = "username"),
            @Result(column = "avatar", property = "avatar"),

    })
    @Select("SELECT * FROM t_sys_user WHERE user_id = #{userId} ")
   SysUser getOne(long userId);

    @Delete("DELETE FROM t_sys_user WHERE user_id =#{userId} ")
    void delete(long userId);

    @Insert("INSERT INTO t_sys_user(mobile,password,username,avatar) VALUES(#{mobile},#{password},#{username},#{avatar}) ")
    void insert(SysUser sysUser);

    @Update("UPDATE t_sys_user SET password=#{password},avatar=#{avatar} WHERE user_id=#{userId} ")
    void update(SysUser sysUser);

}
