package com.training.sgorodecki.homework.homework18.services.api;

import com.training.sgorodecki.homework.homework18.entity.Good;
import com.training.sgorodecki.homework.homework18.entity.Order;

public interface OrderService {

    void addOrder(int id);

    Order getByUserId(int id);

    void updateTotalPriceOfOrder(String username);

    void addGood(Order order, Good good);

    public String getGoods(String username);

}
