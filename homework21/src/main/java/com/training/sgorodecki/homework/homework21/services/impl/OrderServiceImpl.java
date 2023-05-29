package com.training.sgorodecki.homework.homework21.services.impl;

import com.training.sgorodecki.homework.homework21.dao.api.OrderDAO;
import com.training.sgorodecki.homework.homework21.entity.Good;
import com.training.sgorodecki.homework.homework21.entity.Order;
import com.training.sgorodecki.homework.homework21.services.api.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDAO orderDAO;

    public OrderServiceImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public void addOrder(int userId) {
        orderDAO.addOrder(userId);
    }

    @Override
    public Order getByUserId(int id) {
        return orderDAO.getByUserId(id);
    }

    @Override
    public void updateTotalPriceOfOrder(String username) {
        orderDAO.updatePrice(username);
    }

    @Override
    public void addGood(Order order, Good good) {
        orderDAO.addGood(order, good);
    }

    @Override
    public List<Good> getGoods(String username) {
        return orderDAO.getGoods(username);
    }
}