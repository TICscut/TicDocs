package com.service.team.service;

import com.service.team.entity.Team;

public interface TeamService {
    /**
     * 团队注册
     * @return 注册成功返回团队对象，失败返回null
     */
    Team register(String teamname, Integer captainID) throws Exception;
}
