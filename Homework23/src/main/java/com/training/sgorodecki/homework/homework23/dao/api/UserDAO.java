package com.training.sgorodecki.homework.homework23.dao.api;

import com.training.sgorodecki.homework.homework23.entity.User;

public interface UserDAO {

    void addUser(User user);

    User getByLogin(String login);

    User getById(int id);
}