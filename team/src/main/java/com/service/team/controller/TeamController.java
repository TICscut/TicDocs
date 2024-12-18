package com.service.team.controller;

import com.service.team.entity.Team;
import com.service.team.service.MessageReceiver;
import com.service.team.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/team")
public class TeamController {
    private final TeamService teamService;
    private final MessageReceiver messageReceiver;

    @Autowired
    public TeamController(TeamService teamService, MessageReceiver messageReceiver) {
        this.teamService = teamService;
        this.messageReceiver = messageReceiver;
    }

    @RequestMapping("/register")
    public String register(String teamname, Integer captainID){
        try{
            Team team = new Team(teamname, captainID);
            return teamService.register(team).toString();
        } catch (Exception e){
            return e.getMessage();
        }
    }

    @RequestMapping("/getMessage")
    public String getMessage(){
        try{
            return messageReceiver.getLastReceivedMessage().toString();
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
