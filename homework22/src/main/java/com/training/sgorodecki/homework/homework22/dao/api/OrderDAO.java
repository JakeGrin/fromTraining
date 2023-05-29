package com.training.sgorodecki.homework.homework22.dao.api;

import com.training.sgorodecki.homework.homework22.entity.Good;
import com.training.sgorodecki.homework.homework22.entity.Order;
import com.training.sgorodecki.homework.homework22.entity.OrderGood;

import java.util.List;

public interface OrderDAO {

    void addOrder(Order order);

    Order getByUserId(int userId);

    void updatePrice(Order order);

    void saveOrderGood(OrderGood orderGood);

//    List<Good> getGoods(String username);
}
