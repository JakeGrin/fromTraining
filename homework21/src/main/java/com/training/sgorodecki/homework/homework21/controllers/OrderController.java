package com.training.sgorodecki.homework.homework21.controllers;

import com.training.sgorodecki.homework.homework21.authorization.CustomUserPrincipal;
import com.training.sgorodecki.homework.homework21.entity.User;
import com.training.sgorodecki.homework.homework21.services.api.OrderService;
import com.training.sgorodecki.homework.homework21.services.api.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/order")
public class OrderController {

    private static final String USERNAME = "username";
    private static final String USER_BUCKET = "userBucket";
    private static final String TOTAL_COST = "totalCost";
    private static final String ORDER = "order";

    private final OrderService orderService;
    private final UserService userService;

    public OrderController(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping
    public ModelAndView showOrderPage(@AuthenticationPrincipal CustomUserPrincipal customUserPrincipal) {
        User user = customUserPrincipal.getUser();

        final ModelAndView modelAndView = new ModelAndView(ORDER);
        modelAndView.addObject(USERNAME, user.getLogin());
        modelAndView.addObject(USER_BUCKET, orderService.getGoods(user.getLogin()));
        modelAndView.addObject(TOTAL_COST, orderService.getByUserId(
                userService.getByLogin(user.getLogin()).getId()).getTotalPrice());

        return modelAndView;
    }
}