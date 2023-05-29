package com.training.sgorodecki.homework.homework19.services.api;

import com.training.sgorodecki.homework.homework19.entity.Good;
import com.training.sgorodecki.homework.homework19.entity.Order;

public interface OrderService {

    void addOrder(int id);

    Order getOrderByUserId(int id);

    void updateTotalPriceOfOrder(String username);

    void addGoodInOrder(Order order, Good good);

    public String getUserGoods(String username);

}
