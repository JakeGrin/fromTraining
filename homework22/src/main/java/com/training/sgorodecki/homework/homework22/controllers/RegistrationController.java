package com.training.sgorodecki.homework.homework22.controllers;

import com.training.sgorodecki.homework.homework22.dto.UserDto;
import com.training.sgorodecki.homework.homework22.services.api.OrderService;
import com.training.sgorodecki.homework.homework22.services.api.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    private static final String REDIRECT_START = "redirect:start";
    private static final String REDIRECT_ERROR = "redirect:error";

    private final UserService userService;
    private final OrderService orderService;

    public RegistrationController(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    @GetMapping
    public String showRegistrationPage() {
        return "register";
    }

    @PostMapping
    public ModelAndView saveUser(@ModelAttribute("user") UserDto userDto,
                                 @RequestParam(value = "agreement", required = false) Boolean isAgree) {

        if (Objects.nonNull(isAgree)) {
            userService.addUser(userDto);
            orderService.addOrder(userService.getByLogin(userDto.getLogin()).getId());
            return new ModelAndView(REDIRECT_START);
        }
            return new ModelAndView(REDIRECT_ERROR);
        }
    }
