package com.service.user.service;

import com.service.user.dto.TeamRegisterReq;

public interface MessageSender {
    public void sendTeamRegistration(String teamname, String captainId);
}