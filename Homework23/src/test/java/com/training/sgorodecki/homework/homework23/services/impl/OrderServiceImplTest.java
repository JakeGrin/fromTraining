package com.training.sgorodecki.homework.homework23.services.impl;

import com.training.sgorodecki.homework.homework23.config.AppConfiguration;
import com.training.sgorodecki.homework.homework23.config.WebConfiguration;
import com.training.sgorodecki.homework.homework23.dao.api.GoodDAO;
import com.training.sgorodecki.homework.homework23.dao.api.OrderDAO;
import com.training.sgorodecki.homework.homework23.dao.api.UserDAO;
import com.training.sgorodecki.homework.homework23.entity.Good;
import com.training.sgorodecki.homework.homework23.entity.Order;
import com.training.sgorodecki.homework.homework23.entity.User;
import com.training.sgorodecki.homework.homework23.entity.enums.UserRole;
import com.training.sgorodecki.homework.homework23.services.api.OrderService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = {AppConfiguration.class, WebConfiguration.class})
@WebAppConfiguration
public class OrderServiceImplTest {

    @Mock
    private OrderDAO orderDAO;

    @Mock
    private GoodDAO goodDAO;

    @Mock
    private UserDAO userDAO;

    private OrderService orderService;

    @Before
    public void setUp() {
        orderService = new OrderServiceImpl(orderDAO, goodDAO, userDAO);
    }

    @Test
    public void shouldGetOrderByUser() {
        User user = getUser();
        Order order = getOrder(user);

        when(orderDAO.getByUser(any(User.class))).thenReturn(order);
        assertEquals(order, orderService.getByUser(user));
    }

    @Test
    public void shouldGetGoods() {
        String username = "Paul";

        when(userDAO.getByLogin(anyString())).thenReturn(getUser());
        when(orderDAO.getByUser(any(User.class))).thenReturn(getOrder(getUser()));
        when(goodDAO.getGoods(anyInt())).thenReturn(getGoods());

        assertEquals(getGoods(), orderService.getGoods(username));
    }

    @Test
    public void shouldAddGood() {
        when(orderDAO.getById(anyInt())).thenReturn(getOrder(getUser()));
        doNothing().when(orderDAO).updateOrder(any(Order.class));

        orderService.addGood(getOrder(getUser()), getGood());

        verify(orderDAO, times(1)).getById(anyInt());
        verify(orderDAO, times(1)).updateOrder(any(Order.class));
        verifyNoMoreInteractions(orderDAO);
    }

    private List<Good> getGoods() {
        Good book = new Good();
        book.setName("Book");
        book.setId(1);
        book.setPrice(new BigDecimal("20.50"));

        Good phone = new Good();
        phone.setName("Phone");
        phone.setId(2);
        phone.setPrice(new BigDecimal("10.00"));

        return List.of(book, phone);
    }

    private Good getGood() {
        Good phone = new Good();
        phone.setName("Phone");
        phone.setId(2);
        phone.setPrice(new BigDecimal("10.00"));

        return phone;
    }

    private Order getOrder(User user) {
        Order order = new Order();
        order.setId(1);
        order.setUser(user);
        order.setTotalPrice(new BigDecimal("0.00"));
        return order;
    }

    private User getUser() {
        User user = new User();
        user.setLogin("Peter");
        user.setPassword("");
        user.setUserRole(UserRole.USER);
        return user;
    }
}