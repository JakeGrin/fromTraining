package com.training.sgorodecki.homework.homework18.services.impl;

import com.training.sgorodecki.homework.homework18.dao.api.UserDAO;
import com.training.sgorodecki.homework.homework18.dao.impl.UserDAOImpl;
import com.training.sgorodecki.homework.homework18.entity.User;
import com.training.sgorodecki.homework.homework18.services.api.UserService;

public class UserServiceImpl implements UserService {

    private static UserServiceImpl instance;

    private final UserDAO userDAO = new UserDAOImpl();

    public static synchronized UserServiceImpl getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }

    public UserServiceImpl() {
    }

    @Override
    public void addUser(String username) {
        User user = new User();
        user.setLogin(username);
        userDAO.addUser(user);
    }

    @Override
    public User getByLogin(String username) {
        User user = new User();
        user.setLogin(username);
        return userDAO.getByLogin(username);
    }
}