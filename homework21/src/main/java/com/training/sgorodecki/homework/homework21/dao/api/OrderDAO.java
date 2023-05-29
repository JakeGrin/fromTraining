package com.training.sgorodecki.homework.homework21.dao.api;

import com.training.sgorodecki.homework.homework21.entity.Good;
import com.training.sgorodecki.homework.homework21.entity.Order;

import java.util.List;

public interface OrderDAO {

    void addOrder(int userId);

    Order getByUserId(int userId);

    void updatePrice(String username);

    void addGood(Order order, Good good);

    List<Good> getGoods(String username);
}
