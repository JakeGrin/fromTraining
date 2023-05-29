package com.training.sgorodecki.homework.homework19_3.services.impl;

import com.training.sgorodecki.homework.homework19_3.dao.api.UserDAO;
import com.training.sgorodecki.homework.homework19_3.entity.User;
import com.training.sgorodecki.homework.homework19_3.services.api.UserService;
import org.springframework.stereotype.Service;

@Service
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