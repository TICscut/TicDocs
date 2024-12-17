package com.service.team.mapper;

import com.service.team.entity.Team;
import org.apache.ibatis.annotations.Param;

public interface TeamMapper {
    // 根据队伍名查询队伍
    Team selectByTeamname(@Param("teamname") String teamname);

    // 添加队伍
    boolean insertTeam(Team team);
}
