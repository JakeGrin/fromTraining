package com.training.sgorodecki.homework.homework23.dao.api;

import com.training.sgorodecki.homework.homework23.entity.Order;
import com.training.sgorodecki.homework.homework23.entity.User;

public interface OrderDAO {

    Order getById(int id);

    void addOrder(Order order);

    Order getByUser(User user);

    void updateOrder(Order order);
}
