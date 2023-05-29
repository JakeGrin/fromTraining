package com.training.sgorodecki.homework.homework20.controllers;

import com.training.sgorodecki.homework.homework20.services.api.OrderService;
import com.training.sgorodecki.homework.homework20.services.api.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/start")
public class StartController {

    private static final String USERNAME = "username";
    private static final String CHECKED = "checked";
    private static final String REDIRECT_CONSUMER = "redirect:consumer";
    private static final String START = "start";

    private final UserService userService;
    private final OrderService orderService;

    public StartController(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    @GetMapping
    public ModelAndView showStartPage() {
        return new ModelAndView(START);
    }

    @PostMapping
    public ModelAndView saveUserAndOrder(HttpServletRequest req) {
        HttpSession session = req.getSession();
        String username = req.getParameter(USERNAME);
        String checked = req.getParameter(CHECKED);
        session.setAttribute(USERNAME, username);
        session.setAttribute(CHECKED, checked);

        final ModelAndView modelAndView = new ModelAndView(REDIRECT_CONSUMER);
        modelAndView.addObject(USERNAME, username);
        modelAndView.addObject(CHECKED, checked);

        userService.addUser(username);
        orderService.addOrder(userService.getByLogin(username).getId());

        return modelAndView;
    }
}
