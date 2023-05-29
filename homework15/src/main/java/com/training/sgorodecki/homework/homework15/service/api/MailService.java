package com.training.sgorodecki.homework.homework15.service.api;

import com.training.sgorodecki.homework.homework15.model.User;

import java.util.Map;

public interface MailService {

    void sendMessageAboutBug();

    String sendFirstInvitation(User user);

    void sendMeDummyMessagesForAllTopics();

    Map<String, User> getDeveloperEmails();
}
