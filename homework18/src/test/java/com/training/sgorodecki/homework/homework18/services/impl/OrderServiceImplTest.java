package com.training.sgorodecki.homework.homework18.services.impl;

import com.training.sgorodecki.homework.homework18.util.Connector;
import com.training.sgorodecki.homework.homework18.entity.Good;
import com.training.sgorodecki.homework.homework18.entity.Order;
import com.training.sgorodecki.homework.homework18.entity.User;
import com.training.sgorodecki.homework.homework18.services.api.OrderService;
import com.training.sgorodecki.homework.homework18.services.api.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class OrderServiceImplTest {

    private OrderService orderService;
    private UserService userService;

    @Before
    public void setUp() {
        orderService = OrderServiceImpl.getInstance();
        userService = UserServiceImpl.getInstance();
        Connector connector = Connector.getConnectorInstance();
        connector.initConnection();
    }

    @Test
    public void shouldGetOrderByUserId(){
        userService.addUser("Peter");
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
        userService.addUser("Paul");
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

        String expected = "<li>Book 20.5 $</li>";
        String actual = orderService.getGoods("Paul");

        Assert.assertEquals(expected, actual);
    }
}