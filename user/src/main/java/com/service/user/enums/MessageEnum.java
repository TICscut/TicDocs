package com.service.user.enums;

public enum MessageEnum {
    // 注册
    REGISTER_SUCCESS("注册成功"),
    REGISTER_FAIL_INVALID_INPUT("用户名或密码长度不符合要求"),
    REGISTER_FAIL_USERNAME_EXISTS("用户已存在"),
    REGISTER_FAIL_INTERNAL_ERR("服务器内部错误"),

    // 登录
    LOGIN_SUCCESS("登录成功"),
    LOGIN_FAIL_NOT_EXIST("用户不存在"),
    LOGIN_FAIL_WRONG_PASSWORD("密码错误"),

    // jwt token
    TOKEN_REFRESH_SUCCESS("token刷新成功"),
    TOKEN_REFRESH_FAIL_EXPIRED("refresh token已过期"),
    TOKEN_REFRESH_FAIL_USER_NOT_EXIST("用户不存在");

    private final String message;
    MessageEnum(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
} 