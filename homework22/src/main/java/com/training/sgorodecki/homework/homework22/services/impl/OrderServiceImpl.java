package com.training.sgorodecki.homework.homework22.services.impl;

import com.training.sgorodecki.homework.homework22.dao.api.GoodDAO;
import com.training.sgorodecki.homework.homework22.dao.api.OrderDAO;
import com.training.sgorodecki.homework.homework22.entity.Good;
import com.training.sgorodecki.homework.homework22.entity.Order;
import com.training.sgorodecki.homework.homework22.entity.OrderGood;
import com.training.sgorodecki.homework.homework22.services.api.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDAO orderDAO;
    private final GoodDAO goodDAO;

    public OrderServiceImpl(OrderDAO orderDAO, GoodDAO goodDAO) {
        this.orderDAO = orderDAO;
        this.goodDAO = goodDAO;
    }

    @Transactional
    @Override
    public void addOrder(int userId) {
        Order order = new Order();
        order.setUserId(userId);
        order.setTotalPrice(BigDecimal.ZERO);
        orderDAO.addOrder(order);
    }

    @Transactional
    @Override
    public Order getByUserId(int id) {
        return orderDAO.getByUserId(id);
    }

    @Transactional
    @Override
    public void addGood(Order order, Good good) {
        OrderGood orderGood = new OrderGood();
        orderGood.setGoodId(good.getId());
        orderGood.setOrderId(order.getId());
        orderDAO.saveOrderGood(orderGood);

        BigDecimal totalPrice = order.getTotalPrice();
        BigDecimal updatedPrice = totalPrice.add(good.getPrice());
        order.setTotalPrice(updatedPrice);
        orderDAO.updatePrice(order);
    }

    @Transactional
    @Override
    public List<Good> getGoods(String username) {
        return goodDAO.getGoods(username);
    }
}