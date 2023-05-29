package com.training.sgorodecki.homework.homework21.services.api;

import com.training.sgorodecki.homework.homework21.dto.UserDto;
import com.training.sgorodecki.homework.homework21.entity.User;

public interface UserService {

    void addUser(UserDto user);

    User getByLogin(String username);
}
