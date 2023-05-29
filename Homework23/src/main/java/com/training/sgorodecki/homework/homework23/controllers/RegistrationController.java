package com.training.sgorodecki.homework.homework23.controllers;

import com.training.sgorodecki.homework.homework23.dto.UserDto;
import com.training.sgorodecki.homework.homework23.services.api.UserService;
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

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showRegistrationPage() {
        return "register";
    }

    @PostMapping
    public ModelAndView saveUser(@ModelAttribute("user") UserDto userDto,
                                 @RequestParam(value = "agreement", required = false) Boolean isAgree) {

        if (Objects.nonNull(isAgree)) {
            userService.addUserAndOrder(userDto);
            return new ModelAndView(REDIRECT_START);
        }
        return new ModelAndView(REDIRECT_ERROR);
    }
}
