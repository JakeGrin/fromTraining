package com.training.sgorodecki.homework.homework21.dao.api;

import com.training.sgorodecki.homework.homework21.entity.User;

public interface UserDAO {

    void addUser(User user);

    User getByLogin(String login);
}