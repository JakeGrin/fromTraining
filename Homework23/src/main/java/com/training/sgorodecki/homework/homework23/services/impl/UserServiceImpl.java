package com.training.sgorodecki.homework.homework23.services.impl;

import com.training.sgorodecki.homework.homework23.converters.UserConverter;
import com.training.sgorodecki.homework.homework23.dao.api.OrderDAO;
import com.training.sgorodecki.homework.homework23.dao.api.UserDAO;
import com.training.sgorodecki.homework.homework23.dto.UserDto;
import com.training.sgorodecki.homework.homework23.entity.Order;
import com.training.sgorodecki.homework.homework23.entity.User;
import com.training.sgorodecki.homework.homework23.entity.enums.UserRole;
import com.training.sgorodecki.homework.homework23.services.api.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;
    private final UserConverter userConverter;
    private final OrderDAO orderDAO;

    public UserServiceImpl(UserDAO userDAO, UserConverter userConverter, OrderDAO orderDAO) {
        this.userDAO = userDAO;
        this.userConverter = userConverter;
        this.orderDAO = orderDAO;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void addUserAndOrder(UserDto userDto) {
        userDto.setUserRole(UserRole.USER);
        User user = userConverter.toEntity(userDto);
        userDAO.addUser(user);

        Order order = new Order();
        order.setTotalPrice(BigDecimal.ZERO);
        order.setUser(user);
        orderDAO.addOrder(order);
    }
}