package com.training.sgorodecki.homework.homework20.dao.api;

import com.training.sgorodecki.homework.homework20.entity.User;

public interface UserDAO {

    void addUser(User user);

    User getByLogin(String login);
}