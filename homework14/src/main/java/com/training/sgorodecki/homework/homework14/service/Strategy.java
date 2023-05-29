package com.training.sgorodecki.homework.homework14.service;

import com.training.sgorodecki.homework.homework14.model.HttpClient;
import com.training.sgorodecki.homework.homework14.model.UrlConnectionImpl;
import com.training.sgorodecki.homework.homework14.serviceImpl.WebClient;

public class Strategy {
    private WebClient webClient;

    public void execute(String mode, String method, String argument) {
        if (mode.equals("task1")) {
            webClient = new UrlConnectionImpl();
        } else if (mode.equals("task2")) {
            webClient = new HttpClient();
        } else {
            throw new UnsupportedOperationException("Choose task1 or task2");
        }
        chooseMethod(method, argument);
    }

    private void chooseMethod(String method, String argument) {
        if (method.equals("POST")) {
            webClient.publishPost(argument);
        } else if (method.equals("GET")) {
            try {
                webClient.getPostById(Integer.parseInt(argument));
            } catch (NumberFormatException exception) {
                throw new UnsupportedOperationException("Please type a number");
            }
        } else {
            throw new UnsupportedOperationException("Please, type GET or POST");
        }
    }
}
