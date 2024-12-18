package com.service.team.service;

import com.service.team.dto.TeamRegisterReq;
import com.service.team.entity.Team;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MessageReceiverImpl implements MessageReceiver{
    private final RabbitTemplate rabbitTemplate;
    private final TeamService teamService;
    private TeamRegisterReq lastReceivedMessage;

    @Autowired
    public MessageReceiverImpl(RabbitTemplate rabbitTemplate, TeamService teamService) {
        this.rabbitTemplate = rabbitTemplate;
        this.teamService = teamService;
    }

    @Override
    @RabbitListener(queues = "com.team.register")
    public void receiveTeamRegistration(TeamRegisterReq teamRegisterReq) {
        try{
            lastReceivedMessage = teamRegisterReq;
            System.out.println("received: " + lastReceivedMessage.toString());
            Team team = new Team(lastReceivedMessage.getTeamName(),Integer.parseInt(lastReceivedMessage.getCaptainId()));
            teamService.register(team);
            System.out.println("注册成功——team:" + team);
        }catch (Exception e){
            System.out.println("发送异常：" + e.getMessage());
        }

    }

    public TeamRegisterReq getLastReceivedMessage() {
        return lastReceivedMessage;
    }
}