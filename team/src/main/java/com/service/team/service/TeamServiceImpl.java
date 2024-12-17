package com.service.team.service;

import com.service.team.entity.Team;
import com.service.team.mapper.TeamMapper;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService{

    private final TeamMapper teamMapper;

    public TeamServiceImpl(TeamMapper teamMapper) {
        this.teamMapper = teamMapper;
    }

    /**
     * 团队注册
     * @return 注册成功返回团队对象，失败返回null
     */
    public Team register(String teamname, Integer captainID) throws Exception{
        Team team = new Team(teamname, captainID);
        teamMapper.insertTeam(team);
        return team;
    }
}
