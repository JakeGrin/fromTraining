package com.training.sgorodecki.homework.homework19.services.impl;

import com.training.sgorodecki.homework.homework19.entity.Good;
import com.training.sgorodecki.homework.homework19.entity.Order;
import com.training.sgorodecki.homework.homework19.entity.User;
import com.training.sgorodecki.homework.homework19.services.api.OrderService;
import com.training.sgorodecki.homework.homework19.services.api.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class OrderServiceImplTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Test
    public void shouldGetOrderByUserId() {
        userService.addUser("Peter");
        User user = userService.getUserByLogin("Peter");

        orderService.addOrder(user.getId());

        Order order = new Order();
        order.setId(2);
        order.setUserId(2);
        order.setTotalPrice(BigDecimal.valueOf(0.0));

        Assert.assertEquals(order, orderService.getOrderByUserId(user.getId()));
    }

    @Test
    public void shouldGetUserGoods() {
        userService.addUser("Paul");
        User user = userService.getUserByLogin("Paul");

        orderService.addOrder(user.getId());

        Order order = new Order();
        order.setId(1);
        order.setUserId(1);
        order.setTotalPrice(BigDecimal.valueOf(0.0));

        Good good = new Good();
        good.setId(1);
        good.setName("Book");
        good.setPrice(new BigDecimal("20.5"));

        orderService.addGoodInOrder(order, good);

        String expected = "<li>Book 20.5 $</li>";
        String actual = orderService.getUserGoods("Paul");

        Assert.assertEquals(expected, actual);
    }
}