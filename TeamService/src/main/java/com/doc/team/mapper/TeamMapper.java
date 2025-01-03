package com.doc.team.mapper;

import com.doc.team.model.Team;
import org.apache.ibatis.annotations.*;

/**
 * 团队相关的数据库操作接口。
 */
@Mapper
public interface TeamMapper {

    /**
     * 根据团队ID获取团队信息。
     *
     * @param id 团队的唯一标识符。
     * @return 包含团队详细信息的对象，如果找不到则返回null。
     */
    Team getTeamById(@Param("id") Long id);

    /**
     * 创建一个新的团队并设置队长。
     * <p>
     * 该方法会在teams表中插入一条新的记录，并返回生成的团队ID。
     *
     * @param team 接收要创建的队伍信息，不包括id。
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void createTeam(Team team);

    /**
     * 添加成员到指定的团队。
     * <p>
     * 此方法用于向team_members表中插入一条新的记录，表示某个用户成为了某个团队的一员。
     *
     * @param teamID 团队ID，标识要加入的团队。
     * @param memberID 成员的用户ID，标识要加入团队的用户。
     */
    void addMemberToTeam(@Param("teamID") Long teamID, @Param("memberID") Long memberID);

    /**
     * 从团队中删除成员。
     * <p>
     * 移除team_members表中的相应记录，表示某用户不再属于某个团队。
     *
     * @param teamID 团队ID，标识要从中移除成员的团队。
     * @param memberID 成员的用户ID，标识要被移除的用户。
     */
    void deleteMemberFromTeam(@Param("teamID") Long teamID, @Param("memberID") Long memberID);
}