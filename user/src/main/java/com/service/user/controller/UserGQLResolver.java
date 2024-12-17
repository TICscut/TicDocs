package com.service.user.controller;

import com.service.user.service.UserService;
import com.service.user.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import com.service.user.dto.RegisterResp;
import com.service.user.dto.LoginResp;
import com.service.user.entity.User;
import com.service.user.enums.MessageEnum;

@Controller
public class UserGQLResolver {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @Autowired
    public UserGQLResolver(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @MutationMapping
    public RegisterResp registerUser(@Argument String username, @Argument String password) {

        try {
            User user = userService.register(username, password);
            return new RegisterResp(true, MessageEnum.REGISTER_SUCCESS.getMessage());
        } catch (Exception e) {
            return new RegisterResp(false, e.getMessage());
        }
    }

    @MutationMapping
    public LoginResp login(@Argument String username, @Argument String password) {

        try {
            // 登录成功了
            User user = userService.login(username, password);
            String accessToken = jwtUtil.generateAccessToken(username);
            String refreshToken = jwtUtil.generateRefreshToken(username);
            return new LoginResp(true, MessageEnum.LOGIN_SUCCESS.getMessage(), accessToken, refreshToken);
        } catch (Exception e) {
            return new LoginResp(false, e.getMessage(), null, null);
        }
    }

    @MutationMapping
    public LoginResp refreshToken(@Argument String refreshToken) {
        try {
            String[] tokens = userService.refreshUserToken(refreshToken);
            return new LoginResp(true, MessageEnum.TOKEN_REFRESH_SUCCESS.getMessage(), tokens[0], tokens[1]);
        } catch (Exception e) {
            return new LoginResp(false, e.getMessage(), null, null);
        }
    }
}