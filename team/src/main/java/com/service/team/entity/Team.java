package com.service.team.entity;

import java.io.Serializable;
import java.util.Objects;

public class Team {
    /** 团队id **/
    private Integer id;
    /** 团队名称 **/
    private String teamname;
    /** 队长用户id **/
    private Integer captainID;

    /** SerialVersionUI **/
    private static final long serialVersionUID = 1L;

    public Team(String teamname, Integer captainID) {
        this.teamname = teamname;
        this.captainID = captainID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public Integer getCaptainID() {
        return captainID;
    }

    public void setCaptainID(Integer captainID) {
        this.captainID = captainID;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", teamname='" + teamname + '\'' +
                ", captainID=" + captainID +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, teamname, captainID);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team other = (Team) o;
        return Objects.equals(id, other.id) &&
                Objects.equals(teamname, other.teamname) &&
                Objects.equals(captainID, other.captainID);
    }
}
