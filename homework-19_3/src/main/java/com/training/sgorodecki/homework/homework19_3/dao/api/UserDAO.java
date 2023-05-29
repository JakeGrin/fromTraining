package com.training.sgorodecki.homework.homework19_3.dao.api;

import com.training.sgorodecki.homework.homework19_3.entity.User;

public interface UserDAO {

    void addUser(User user);

    User getUserByLogin(String login);
}