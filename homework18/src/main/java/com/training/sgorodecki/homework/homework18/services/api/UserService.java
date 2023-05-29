package com.training.sgorodecki.homework.homework18.services.api;

import com.training.sgorodecki.homework.homework18.entity.User;

public interface UserService {

    void addUser(String username);

    User getByLogin(String username);
}
