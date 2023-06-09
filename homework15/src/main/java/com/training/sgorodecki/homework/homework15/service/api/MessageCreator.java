package com.training.sgorodecki.homework.homework15.service.api;

import com.training.sgorodecki.homework.homework15.model.User;

import java.util.List;

public interface MessageCreator {

    String createMessage(List<String> recipients, String theme);

    String createPersonalMessage(User user, String theme);
}
