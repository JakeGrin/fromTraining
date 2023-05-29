package com.training.sgorodecki.homework.homework21.services.impl;

import com.training.sgorodecki.homework.homework21.converters.UserConverter;
import com.training.sgorodecki.homework.homework21.dao.api.UserDAO;
import com.training.sgorodecki.homework.homework21.dto.UserDto;
import com.training.sgorodecki.homework.homework21.entity.User;
import com.training.sgorodecki.homework.homework21.entity.enums.UserRole;
import com.training.sgorodecki.homework.homework21.services.api.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;
    private final UserConverter userConverter;

    public UserServiceImpl(UserDAO userDAO, UserConverter userConverter) {
        this.userDAO = userDAO;
        this.userConverter = userConverter;
    }

    @Override
    public void addUser(UserDto userDto) {
        userDto.setUserRole(UserRole.USER);
        User user = userConverter.toEntity(userDto);
        userDAO.addUser(user);
    }

    @Override
    public User getByLogin(String username) {
        User user = new User();
        user.setLogin(username);
        return userDAO.getByLogin(username);
    }
}