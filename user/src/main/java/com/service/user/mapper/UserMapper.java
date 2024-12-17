package com.service.user.mapper;

import com.service.user.entity.User;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    // 根据用户名查询用户
    User selectByUsername(@Param("username") String username);

    // 插入用户
    boolean insertUser(User user);
}