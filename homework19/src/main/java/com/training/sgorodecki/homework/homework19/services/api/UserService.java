package com.training.sgorodecki.homework.homework19.services.api;

import com.training.sgorodecki.homework.homework19.entity.User;

public interface UserService {

    void addUser(String username);

    User getUserByLogin(String username);
}
