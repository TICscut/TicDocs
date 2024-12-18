package com.service.user.service;

import com.service.user.dto.TeamRegisterReq;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MessageSenderImpl implements MessageSender {
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public MessageSenderImpl(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendTeamRegistration(String teamname, String captainId){
        TeamRegisterReq teamRegisterReq = new TeamRegisterReq(teamname, captainId);
        // 问题在这里，我没办法发送dto对象过去
        rabbitTemplate.convertAndSend("com.team.register", teamRegisterReq);
    }
}
