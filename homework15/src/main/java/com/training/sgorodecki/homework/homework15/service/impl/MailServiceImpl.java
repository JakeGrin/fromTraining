package com.training.sgorodecki.homework.homework15.service.impl;

import com.training.sgorodecki.homework.homework15.exception.RecipientsException;
import com.training.sgorodecki.homework.homework15.model.User;
import com.training.sgorodecki.homework.homework15.model.enums.Topic;
import com.training.sgorodecki.homework.homework15.service.api.MailSender;
import com.training.sgorodecki.homework.homework15.service.api.MailService;
import com.training.sgorodecki.homework.homework15.service.api.MessageCreator;
import com.training.sgorodecki.homework.homework15.service.api.UserService;
import com.training.sgorodecki.homework.homework15.util.UserMailExtractor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.training.sgorodecki.homework.homework15.model.enums.Topic.BUG;
import static com.training.sgorodecki.homework.homework15.model.enums.Topic.TASK;

public class MailServiceImpl implements MailService {

    private static final Logger LOGGER = LogManager.getLogger(MailServiceImpl.class);
    private final MessageCreator messageCreator;
    private final UserService userService;
    private final MailSender mailSender;

    public MailServiceImpl(MessageCreator messageCreator, UserService userService, MailSender mailSender) {
        this.messageCreator = messageCreator;
        this.userService = userService;
        this.mailSender = mailSender;
    }

    @Override
    public void sendMessageAboutBug() {
        List<User> developers = userService.getDevelopers();

        List<String> recipients = UserMailExtractor.getMailsFromUsers(developers);

        checkRecipients(recipients);

        String message = messageCreator.createMessage(recipients, BUG.getText());

        mailSender.sendMail(message);
        LOGGER.debug("Message: {} was sent to the user{}", message, recipients);
    }

    @Override
    public String sendFirstInvitation(User user) {
        String personalMessage = messageCreator.createPersonalMessage(user, TASK.getText());

        mailSender.sendMail(personalMessage);

        LOGGER.debug("Message: {} was sent to the user {}", personalMessage, user);
        return personalMessage;
    }

    @Override
    public void sendMeDummyMessagesForAllTopics() {
        User currentUser = userService.getCurrentUser()
                .orElseThrow(NoSuchElementException::new);

        Set<String> messages = getMessagesForUser(currentUser);

        messages.forEach(mailSender::sendMail);
        LOGGER.debug("Message: {} was sent to the user {}", messages, currentUser);
    }

    @Override
    public Map<String, User> getDeveloperEmails() {
        return userService.getDevelopers().stream()
                .collect(Collectors.toMap(User::getEmail, Function.identity()));
    }

    private void checkRecipients(List<String> recipients) {
        if (recipients.isEmpty()) {
            throw new RecipientsException("Recipients list is empty.");
        }
    }

    private Set<String> getMessagesForUser(User currentUser) {
        return Arrays.stream(Topic.values())
                .map(Topic::getText)
                .map(text -> messageCreator.createPersonalMessage(currentUser, text))
                .collect(Collectors.toSet());
    }
}
