package com.service.user.dto;

public class RegisterResp {
    private boolean success;
    private String message;

    public RegisterResp(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}