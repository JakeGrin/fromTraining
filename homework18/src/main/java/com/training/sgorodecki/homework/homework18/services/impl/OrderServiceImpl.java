package com.training.sgorodecki.homework.homework18.services.impl;

import com.training.sgorodecki.homework.homework18.dao.api.OrderDAO;
import com.training.sgorodecki.homework.homework18.dao.impl.OrderDAOImpl;
import com.training.sgorodecki.homework.homework18.entity.Good;
import com.training.sgorodecki.homework.homework18.entity.Order;
import com.training.sgorodecki.homework.homework18.util.PageUtil;
import com.training.sgorodecki.homework.homework18.services.api.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private static OrderServiceImpl instance;

    private final OrderDAO orderDAO = new OrderDAOImpl();

    public static synchronized OrderServiceImpl getInstance() {
        if (instance == null) {
            instance = new OrderServiceImpl();
        }
        return instance;
    }

    public OrderServiceImpl() {
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
    public String getGoods(String username) {
        List<Good> userGoods = orderDAO.getGoods(username);
        return PageUtil.makeNumberedList(userGoods);
    }
}