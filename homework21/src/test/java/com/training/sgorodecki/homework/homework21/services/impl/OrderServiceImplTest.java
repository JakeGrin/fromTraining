package com.training.sgorodecki.homework.homework21.services.impl;

import com.training.sgorodecki.homework.homework21.config.AppConfiguration;
import com.training.sgorodecki.homework.homework21.config.WebConfiguration;
import com.training.sgorodecki.homework.homework21.dto.UserDto;
import com.training.sgorodecki.homework.homework21.entity.Good;
import com.training.sgorodecki.homework.homework21.entity.Order;
import com.training.sgorodecki.homework.homework21.entity.User;
import com.training.sgorodecki.homework.homework21.entity.enums.UserRole;
import com.training.sgorodecki.homework.homework21.services.api.OrderService;
import com.training.sgorodecki.homework.homework21.services.api.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfiguration.class, WebConfiguration.class})
@WebAppConfiguration
public class OrderServiceImplTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Test
    public void shouldGetOrderByUserId() {
        UserDto userDto = new UserDto();
        userDto.setLogin("Peter");
        userDto.setPassword("");
        userDto.setUserRole(UserRole.USER);
        userService.addUser(userDto);
        User user = userService.getByLogin("Peter");

        orderService.addOrder(user.getId());

        Order order = new Order();
        order.setId(2);
        order.setUserId(2);
        order.setTotalPrice(BigDecimal.valueOf(0.0));

        Assert.assertEquals(order, orderService.getByUserId(user.getId()));
    }

    @Test
    public void shouldGetUserGoods() {
        UserDto userDto = new UserDto();
        userDto.setLogin("Paul");
        userDto.setPassword("");
        userDto.setUserRole(UserRole.USER);
        userService.addUser(userDto);
        User user = userService.getByLogin("Paul");

        orderService.addOrder(user.getId());

        Order order = new Order();
        order.setId(1);
        order.setUserId(1);
        order.setTotalPrice(BigDecimal.valueOf(0.0));

        Good good = new Good();
        good.setId(1);
        good.setName("Book");
        good.setPrice(new BigDecimal("20.5"));

        orderService.addGood(order, good);

        List<Good> expected = List.of(good);
        List<Good> actual = orderService.getGoods("Paul");

        Assert.assertEquals(expected, actual);
    }
}