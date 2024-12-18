package com.service.team.mapper;

import com.service.team.entity.Team;
import org.apache.ibatis.annotations.Param;

public interface TeamMapper {
    /**
     * 根据给定的ID查询Team信息。
     *
     * @param id 要查询的Team的ID
     * @return 返回对应的Team对象，如果不存在则返回null
     */
    Team getTeamById(@Param("id") int id);

    /**
     * 根据给定的名称查询Team信息。
     *
     * @param teamname 要查询的Team的名称
     * @return 返回对应的Team对象，如果不存在则返回null
     */
    Team getTeamByName(@Param("teamname") String teamname);

    /**
     * 向team表中插入一个新的Team记录。
     *
     * @param team 要插入的Team对象
     */
    void insertTeam(Team team);
}
