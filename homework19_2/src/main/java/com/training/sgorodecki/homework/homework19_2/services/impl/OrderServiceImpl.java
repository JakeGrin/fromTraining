package com.training.sgorodecki.homework.homework19_2.services.impl;

import com.training.sgorodecki.homework.homework19_2.dao.api.OrderDAO;
import com.training.sgorodecki.homework.homework19_2.entity.Good;
import com.training.sgorodecki.homework.homework19_2.entity.Order;
import com.training.sgorodecki.homework.homework19_2.services.PageUtil;
import com.training.sgorodecki.homework.homework19_2.services.api.OrderService;
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