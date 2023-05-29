package com.training.sgorodecki.homework.homework23.services.impl;

import com.training.sgorodecki.homework.homework23.dao.api.GoodDAO;
import com.training.sgorodecki.homework.homework23.dao.api.OrderDAO;
import com.training.sgorodecki.homework.homework23.dao.api.UserDAO;
import com.training.sgorodecki.homework.homework23.entity.Good;
import com.training.sgorodecki.homework.homework23.entity.Order;
import com.training.sgorodecki.homework.homework23.entity.User;
import com.training.sgorodecki.homework.homework23.services.api.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDAO orderDAO;
    private final GoodDAO goodDAO;
    private final UserDAO userDAO;

    public OrderServiceImpl(OrderDAO orderDAO, GoodDAO goodDAO, UserDAO userDAO) {
        this.orderDAO = orderDAO;
        this.goodDAO = goodDAO;
        this.userDAO = userDAO;
    }

    @Transactional
    @Override
    public Order getByUser(User user) {
        return orderDAO.getByUser(user);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public List<Good> getGoods(String username) {
        Order order = orderDAO.getByUser(userDAO.getByLogin(username));
        return goodDAO.getGoods(order.getId());
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void addGood(Order order, Good good) {
        Order savedOrder = orderDAO.getById(order.getId());
        savedOrder.getGoods().add(good);

        BigDecimal totalPrice = order.getTotalPrice();
        BigDecimal updatedPrice = totalPrice.add(good.getPrice());
        savedOrder.setTotalPrice(updatedPrice);
        orderDAO.updateOrder(savedOrder);
    }
}