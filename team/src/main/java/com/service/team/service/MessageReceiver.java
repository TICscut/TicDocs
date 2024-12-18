package com.service.team.service;

import com.service.team.dto.TeamRegisterReq;

import java.util.Map;

public interface MessageReceiver {
    public void receiveTeamRegistration(String message);

    public TeamRegisterReq getLastReceivedMessage();
}
