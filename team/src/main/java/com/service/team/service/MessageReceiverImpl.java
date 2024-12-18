package com.service.team.service;

import com.service.team.dto.TeamRegisterReq;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MessageReceiverImpl implements MessageReceiver{
    private final RabbitTemplate rabbitTemplate;
    private TeamRegisterReq lastReceivedMessage;

    @Autowired
    public MessageReceiverImpl(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    @RabbitListener(queues = "com.team.register")
    public void receiveTeamRegistration(String message) {
        // 问题在这里，我如果把参数写成dto对象，就会出错
        lastReceivedMessage = new TeamRegisterReq(message, "1");
        System.out.println("received: " + lastReceivedMessage);
    }

    public TeamRegisterReq getLastReceivedMessage() {
        return lastReceivedMessage;
    }
}