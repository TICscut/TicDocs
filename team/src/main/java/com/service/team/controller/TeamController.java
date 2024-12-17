package com.service.team.controller;

import com.service.team.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/team")
public class TeamController {
    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @RequestMapping("/register")
    public String register(String teamname, Integer captainID){
        try{
            return teamService.register(teamname, captainID).toString();
        } catch (Exception e){
            return e.getMessage();
        }

    }
}
