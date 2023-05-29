package com.training.sgorodecki.homework.homework20.controllers;

import com.training.sgorodecki.homework.homework20.services.api.OrderService;
import com.training.sgorodecki.homework.homework20.services.api.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

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
    public ModelAndView showOrderPage(HttpSession session) {
        String username = (String) session.getAttribute(USERNAME);

        final ModelAndView modelAndView = new ModelAndView(ORDER);
        modelAndView.addObject(USERNAME, username);
        modelAndView.addObject(USER_BUCKET, orderService.getGoods(username));
        modelAndView.addObject(TOTAL_COST, orderService.getByUserId(
                userService.getByLogin(username).getId()).getTotalPrice());

        return modelAndView;
    }
}