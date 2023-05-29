package com.training.sgorodecki.homework.homework22.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/start")
public class StartController {

    private static final String START = "start";

    @GetMapping
    public ModelAndView showStartPage() {
        return new ModelAndView(START);
    }
}