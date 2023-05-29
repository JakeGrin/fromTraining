package com.training.sgorodecki.homework.homework22.dao.api;

import com.training.sgorodecki.homework.homework22.entity.User;

public interface UserDAO {

    void addUser(User user);

    User getByLogin(String login);
}