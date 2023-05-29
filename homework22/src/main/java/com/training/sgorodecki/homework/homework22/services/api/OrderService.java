package com.training.sgorodecki.homework.homework22.services.api;

import com.training.sgorodecki.homework.homework22.entity.Good;
import com.training.sgorodecki.homework.homework22.entity.Order;

import java.util.List;

public interface OrderService {

    void addOrder(int id);

    Order getByUserId(int id);

    void addGood(Order order, Good good);

    List<Good> getGoods(String username);
}