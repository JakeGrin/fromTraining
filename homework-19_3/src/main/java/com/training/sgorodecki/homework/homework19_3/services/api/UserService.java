package com.training.sgorodecki.homework.homework19_3.services.api;

import com.training.sgorodecki.homework.homework19_3.entity.User;

public interface UserService {

    void addUser(String username);

    User getUserByLogin(String username);
}
