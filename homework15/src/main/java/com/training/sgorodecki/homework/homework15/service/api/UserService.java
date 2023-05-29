package com.training.sgorodecki.homework.homework15.service.api;

import com.training.sgorodecki.homework.homework15.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> getCurrentUser();

    List<User> getDevelopers();
}
