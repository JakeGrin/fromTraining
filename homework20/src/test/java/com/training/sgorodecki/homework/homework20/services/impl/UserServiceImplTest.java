package com.training.sgorodecki.homework.homework20.services.impl;

import com.training.sgorodecki.homework.homework20.config.AppConfiguration;
import com.training.sgorodecki.homework.homework20.config.WebConfiguration;
import com.training.sgorodecki.homework.homework20.entity.User;
import com.training.sgorodecki.homework.homework20.services.api.UserService;
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