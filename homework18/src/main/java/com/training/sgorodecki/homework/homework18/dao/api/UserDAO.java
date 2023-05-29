package com.training.sgorodecki.homework.homework18.dao.api;

import com.training.sgorodecki.homework.homework18.entity.User;

public interface UserDAO {

    void addUser(User user);

    User getByLogin(String login);
}