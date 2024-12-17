package com.service.user.dto;

public class LoginResp {
    private boolean success;
    private String message;
    private String accessToken;
    private String refreshToken;

    public LoginResp(boolean success, String message, String accessToken, String refreshToken) {
        this.success = success;
        this.message = message;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}