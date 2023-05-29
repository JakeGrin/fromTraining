package com.training.sgorodecki.homework.homework19_2.services.api;

import com.training.sgorodecki.homework.homework19_2.entity.User;

public interface UserService {

    void addUser(String username);

    User getUserByLogin(String username);
}
