package com.training.sgorodecki.homework.homework22.dto;

import com.training.sgorodecki.homework.homework22.entity.enums.UserRole;

public class UserDto {

    public UserDto() {
    }

    private int id;
    private String login;
    private String password;
    private UserRole userRole;

    public UserDto(int id, String login, String password, UserRole userRole) {
    }

    public UserDto(String login, String password, UserRole userRole) {
        this.login = login;
        this.password = password;
        this.userRole = userRole;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
