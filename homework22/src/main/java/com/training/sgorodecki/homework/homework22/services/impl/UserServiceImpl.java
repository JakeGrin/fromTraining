package com.training.sgorodecki.homework.homework22.services.impl;

import com.training.sgorodecki.homework.homework22.converters.UserConverter;
import com.training.sgorodecki.homework.homework22.dao.api.UserDAO;
import com.training.sgorodecki.homework.homework22.dto.UserDto;
import com.training.sgorodecki.homework.homework22.entity.User;
import com.training.sgorodecki.homework.homework22.entity.enums.UserRole;
import com.training.sgorodecki.homework.homework22.services.api.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;
    private final UserConverter userConverter;

    public UserServiceImpl(UserDAO userDAO, UserConverter userConverter) {
        this.userDAO = userDAO;
        this.userConverter = userConverter;
    }

    @Transactional
    @Override
    public void addUser(UserDto userDto) {
        userDto.setUserRole(UserRole.USER);
        User user = userConverter.toEntity(userDto);
        userDAO.addUser(user);
    }

    @Transactional
    @Override
    public User getByLogin(String username) {
        return userDAO.getByLogin(username);
    }
}