package com.service.team.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class TeamRegisterReq implements Serializable {
    @JsonProperty
    private String teamName;
    @JsonProperty
    private String captainId;

    // Constructors, getters, and setters omitted for brevity
    public TeamRegisterReq() {}

    public TeamRegisterReq(String teamName, String captainId) {
        this.teamName = teamName;
        this.captainId = captainId;
    }

    // Getters and setters
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCaptainId() {
        return captainId;
    }

    public void setCaptainId(String captainId) {
        this.captainId = captainId;
    }

    @Override
    public String toString() {
        return "TeamRegisterReq{" +
                "teamName='" + teamName + '\'' +
                ", captainId='" + captainId + '\'' +
                '}';
    }
}
