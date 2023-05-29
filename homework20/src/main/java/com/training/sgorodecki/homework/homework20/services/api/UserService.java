package com.training.sgorodecki.homework.homework20.services.api;

import com.training.sgorodecki.homework.homework20.entity.User;

public interface UserService {

    void addUser(String username);

    User getByLogin(String username);
}
