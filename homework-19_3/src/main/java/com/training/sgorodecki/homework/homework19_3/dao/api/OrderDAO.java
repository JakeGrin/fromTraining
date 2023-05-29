package com.training.sgorodecki.homework.homework19_3.dao.api;

import com.training.sgorodecki.homework.homework19_3.entity.Good;
import com.training.sgorodecki.homework.homework19_3.entity.Order;

import java.util.List;

public interface OrderDAO {

    void addOrder(int userId);

    Order getOrderByUserId(int userId);

    void updateTotalPriceOfOrder(String username);

    void addGoodInOrder(Order order, Good good);

    List<Good> getUserGoods(String username);
}
