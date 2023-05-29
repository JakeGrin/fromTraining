package com.training.sgorodecki.homework.homework22.services.api;

import com.training.sgorodecki.homework.homework22.dto.UserDto;
import com.training.sgorodecki.homework.homework22.entity.User;

public interface UserService {

    void addUser(UserDto user);

    User getByLogin(String username);
}
