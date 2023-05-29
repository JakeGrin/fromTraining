package com.training.sgorodecki.homework.homework23.controllers;

import com.training.sgorodecki.homework.homework23.authorization.CustomUserPrincipal;
import com.training.sgorodecki.homework.homework23.entity.Good;
import com.training.sgorodecki.homework.homework23.entity.Order;
import com.training.sgorodecki.homework.homework23.entity.User;
import com.training.sgorodecki.homework.homework23.services.api.GoodService;
import com.training.sgorodecki.homework.homework23.services.api.OrderService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/consumer")
public class ConsumerController {

    private static final String USERNAME = "username";
    private static final String CURRENT_USER_BUCKET = "currentUserBucket";
    private static final String MAKE_GOOD_LIST = "makeGoodList";
    private static final String CONSUMER = "consumer";
    private static final String ID = "id";
    private static final String REDIRECT_CONSUMER = "redirect:consumer";

    private final OrderService orderService;
    private final GoodService goodService;

    public ConsumerController(OrderService orderService, GoodService goodService) {
        this.orderService = orderService;
        this.goodService = goodService;
    }

    @GetMapping
    public ModelAndView showConsumerPage(@AuthenticationPrincipal CustomUserPrincipal customUserPrincipal) {
        User user = customUserPrincipal.getUser();

        final ModelAndView modelAndView = new ModelAndView(CONSUMER);

        modelAndView.addObject(USERNAME, user.getLogin());
        modelAndView.addObject(CURRENT_USER_BUCKET, orderService.getGoods(user.getLogin()));
        modelAndView.addObject(MAKE_GOOD_LIST, goodService.getAll());

        return modelAndView;
    }

    @PostMapping
    public ModelAndView addGoodAndUpdatePrice(
            @AuthenticationPrincipal CustomUserPrincipal customUserPrincipal,
            @RequestParam("id") int id
    ) {
        User user = customUserPrincipal.getUser();

        final ModelAndView modelAndView = new ModelAndView(REDIRECT_CONSUMER);
        modelAndView.addObject(ID, id);
        modelAndView.addObject(USERNAME, user.getLogin());

        Good good = goodService.getById(id);
        Order order = orderService.getByUser(user);
        orderService.addGood(order, good);

        return modelAndView;
    }
}