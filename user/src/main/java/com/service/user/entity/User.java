package com.service.user.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * user
 * @author coderYoga KC1zs4
 */
public class User implements Serializable {

    /** 用户ID */
    private Integer id;
    /** 用户名 */
    private String username;
    /** 密码 */
    private String hashedPasswd;

    /** SerialVersionUID */
    private static final long serialVersionUID = 1L;

    public User(String username, String hashedPasswd) {
        this.username = username;
        this.hashedPasswd = hashedPasswd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User other = (User) o;
        return Objects.equals(id, other.id) &&
               Objects.equals(username, other.username) &&
               Objects.equals(hashedPasswd, other.hashedPasswd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, hashedPasswd);
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }

    // getter和setter
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUserame(String username) {
        this.username = username;
    }

    public String getHashedPasswd() {
        return hashedPasswd;
    }
    public void setHashedPasswd(String hashedPasswd) {
        this.hashedPasswd = hashedPasswd;
    }

}