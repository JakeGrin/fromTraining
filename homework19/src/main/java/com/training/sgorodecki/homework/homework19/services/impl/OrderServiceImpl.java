package com.training.sgorodecki.homework.homework19.services.impl;

import com.training.sgorodecki.homework.homework19.dao.api.OrderDAO;
import com.training.sgorodecki.homework.homework19.entity.Good;
import com.training.sgorodecki.homework.homework19.entity.Order;
import com.training.sgorodecki.homework.homework19.services.PageUtil;
import com.training.sgorodecki.homework.homework19.services.api.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {


    private final OrderDAO orderDAO ;


    public OrderServiceImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public void addOrder(int userId) {
        orderDAO.addOrder(userId);
    }

    @Override
    public Order getOrderByUserId(int id) {
        return orderDAO.getOrderByUserId(id);
    }

    @Override
    public void updateTotalPriceOfOrder(String username) {
        orderDAO.updateTotalPriceOfOrder(username);
    }

    @Override
    public void addGoodInOrder(Order order, Good good) {
        orderDAO.addGoodInOrder(order, good);
    }

    @Override
    public String getUserGoods(String username) {
        List<Good> userGoods = orderDAO.getUserGoods(username);
        return PageUtil.makeNumberedList(userGoods);
    }
}