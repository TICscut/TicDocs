package com.service.user.service;

import com.service.user.entity.User;

public interface UserService {
    /**
     * 用户注册
     * @return 注册成功返回用户对象,失败返回null
     */
    User register(String username, String password) throws Exception;

    /**
     * 用户登录
     * @return 登录成功返回用户信息,失败返回null
     */
    User login(String username, String password) throws Exception;

    /**
     * 刷新token
     * @return 刷新成功返回新token,失败返回null
     */
    String[] refreshUserToken(String refreshToken) throws Exception;
}
