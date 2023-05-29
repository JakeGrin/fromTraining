package com.training.sgorodecki.homework.homework21.services.impl;

import com.training.sgorodecki.homework.homework21.config.AppConfiguration;
import com.training.sgorodecki.homework.homework21.config.WebConfiguration;
import com.training.sgorodecki.homework.homework21.converters.UserConverter;
import com.training.sgorodecki.homework.homework21.dto.UserDto;
import com.training.sgorodecki.homework.homework21.entity.User;
import com.training.sgorodecki.homework.homework21.entity.enums.UserRole;
import com.training.sgorodecki.homework.homework21.services.api.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfiguration.class, WebConfiguration.class})
@WebAppConfiguration
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserConverter userConverter;

    @Test
    public void shouldAddAndGetUser() {
        UserDto userDto = new UserDto();
        userDto.setLogin("Peter");
        userDto.setPassword("");
        userDto.setUserRole(UserRole.USER);

        userService.addUser(userDto);

        User user = userConverter.toEntity(userDto);
        User userFromDB = userService.getByLogin("Peter");

        Assert.assertEquals(user, userFromDB);
    }
}