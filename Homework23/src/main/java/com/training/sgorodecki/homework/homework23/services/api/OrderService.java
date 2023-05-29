package com.training.sgorodecki.homework.homework23.services.api;

import com.training.sgorodecki.homework.homework23.entity.Good;
import com.training.sgorodecki.homework.homework23.entity.Order;
import com.training.sgorodecki.homework.homework23.entity.User;

import java.util.List;

public interface OrderService {

    Order getByUser(User user);

    void addGood(Order order, Good good);

    List<Good> getGoods(String username);
}