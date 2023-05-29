package com.training.sgorodecki.homework.homework19.services.impl;

import com.training.sgorodecki.homework.homework19.dao.api.UserDAO;
import com.training.sgorodecki.homework.homework19.entity.User;
import com.training.sgorodecki.homework.homework19.services.api.UserService;

public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void addUser(String username) {
        User user = new User();
        user.setLogin(username);
        userDAO.addUser(user);
    }

    @Override
    public User getUserByLogin(String username) {
        User user = new User();
        user.setLogin(username);
        return userDAO.getUserByLogin(username);
    }
}