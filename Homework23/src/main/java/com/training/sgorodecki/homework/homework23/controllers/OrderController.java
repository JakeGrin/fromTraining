package com.training.sgorodecki.homework.homework23.controllers;

import com.training.sgorodecki.homework.homework23.authorization.CustomUserPrincipal;
import com.training.sgorodecki.homework.homework23.entity.User;
import com.training.sgorodecki.homework.homework23.services.api.OrderService;
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

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ModelAndView showOrderPage(@AuthenticationPrincipal CustomUserPrincipal customUserPrincipal) {
        User user = customUserPrincipal.getUser();

        final ModelAndView modelAndView = new ModelAndView(ORDER);
        modelAndView.addObject(USERNAME, user.getLogin());
        modelAndView.addObject(USER_BUCKET, orderService.getGoods(user.getLogin()));
        modelAndView.addObject(TOTAL_COST, orderService.getByUser(user).getTotalPrice());

        return modelAndView;
    }
}