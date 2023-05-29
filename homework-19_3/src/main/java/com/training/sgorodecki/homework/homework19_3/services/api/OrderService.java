package com.training.sgorodecki.homework.homework19_3.services.api;

import com.training.sgorodecki.homework.homework19_3.entity.Good;
import com.training.sgorodecki.homework.homework19_3.entity.Order;

public interface OrderService {

    void addOrder(int id);

    Order getOrderByUserId(int id);

    void updateTotalPriceOfOrder(String username);

    void addGoodInOrder(Order order, Good good);

    public String getUserGoods(String username);

}
