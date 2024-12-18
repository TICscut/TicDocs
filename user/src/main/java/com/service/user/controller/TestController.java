package com.service.user.controller;

import com.service.user.dto.TeamRegisterReq;
import com.service.user.service.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/test")
public class TestController {
    private final MessageSender messageSender;

    @Autowired
    public TestController(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @RequestMapping("/sendMessage")
    public String sendMessage(@RequestParam String teamName, @RequestParam String captainId){
        try{
            messageSender.sendTeamRegistration(teamName, captainId);
            return "OK";
        }catch (Exception e){
            return e.getMessage();
        }
    }
}