package com.training.sgorodecki.homework.homework18.services.impl;

import com.training.sgorodecki.homework.homework18.util.Connector;
import com.training.sgorodecki.homework.homework18.entity.User;
import com.training.sgorodecki.homework.homework18.services.api.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserServiceImplTest {

    private UserService userService;

    @Before
    public void setUp() {
        userService = UserServiceImpl.getInstance();
        Connector connector = Connector.getConnectorInstance();
        connector.initConnection();
    }

    @Test
    public void shouldAddAndGetUser() {

        User user = new User();
        String username = "John";
        user.setLogin(username);
        user.setId(1);

        userService.addUser(username);
        User userFromDB = userService.getByLogin(username);
        Assert.assertEquals(user, userFromDB);
    }
}