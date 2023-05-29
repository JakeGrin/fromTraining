package com.training.sgorodecki.homework.homework20.controllers;

import com.training.sgorodecki.homework.homework20.entity.Good;
import com.training.sgorodecki.homework.homework20.entity.Order;
import com.training.sgorodecki.homework.homework20.services.api.GoodService;
import com.training.sgorodecki.homework.homework20.services.api.OrderService;
import com.training.sgorodecki.homework.homework20.services.api.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

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
    private final UserService userService;

    public ConsumerController(OrderService orderService, GoodService goodService, UserService userService) {
        this.orderService = orderService;
        this.goodService = goodService;
        this.userService = userService;
    }

    @GetMapping
    public ModelAndView showConsumerPage(HttpSession session) {
        String username = (String) session.getAttribute(USERNAME);

        final ModelAndView modelAndView = new ModelAndView(CONSUMER);
        modelAndView.addObject(USERNAME, username);
        modelAndView.addObject(CURRENT_USER_BUCKET, orderService.getGoods(username));
        modelAndView.addObject(MAKE_GOOD_LIST, goodService.getAll());

        return modelAndView;
    }

    @PostMapping
    public ModelAndView addGoodAndUpdatePrice(
            HttpSession session,
            @RequestParam("id") String id
    ) {
        String username = (String) session.getAttribute(USERNAME);

        final ModelAndView modelAndView = new ModelAndView(REDIRECT_CONSUMER);
        modelAndView.addObject(ID, id);
        modelAndView.addObject(USERNAME, username);

        Good good = goodService.getById(Integer.parseInt(id));
        Order order = orderService.getByUserId(userService.getByLogin(username).getId());
        orderService.addGood(order, good);
        orderService.updateTotalPriceOfOrder(username);

        return modelAndView;
    }
}