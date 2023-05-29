package com.training.sgorodecki.homework.homework15.service.impl;

import com.training.sgorodecki.homework.homework15.exception.RecipientsException;
import com.training.sgorodecki.homework.homework15.model.User;
import com.training.sgorodecki.homework.homework15.model.enums.Topic;
import com.training.sgorodecki.homework.homework15.service.api.MailSender;
import com.training.sgorodecki.homework.homework15.service.api.MessageCreator;
import com.training.sgorodecki.homework.homework15.service.api.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)

public class MailServiceImplTest {

    private static final String USER_DEVELOPER_EMAIL = "google@tut.com";
    private static final String MESSAGE_TEXT = "Bug Report";
    private static final String RECIPIENTS_EMAIL = "mail@mail.com";
    private static final String LOCAL_MESSAGE_TEXT = "Hello";
    private static final int SINGLE_INVOCATION = 1;
    @Mock
    private MessageCreator messageCreator;

    @Mock
    private UserService userService;

    @Mock
    private MailSender mailSender;

    @InjectMocks
    private MailServiceImpl mailService;

    private List<User> developers;
    private User userDeveloper;
    private String message;
    private List<String> recipients;
    private Map<String, User> map;
    private User anotherUserDeveloper;

    @Before
    public void setUp() {
        userDeveloper = new User();
        userDeveloper.setEmail(USER_DEVELOPER_EMAIL);
        anotherUserDeveloper = new User();
        developers = new ArrayList<>();
        developers.add(userDeveloper);
        developers.add(anotherUserDeveloper);
        message = MESSAGE_TEXT;
        recipients = new ArrayList<>();
        recipients.add(RECIPIENTS_EMAIL);
        map = new HashMap<>();
        map.put(userDeveloper.getEmail(), userDeveloper);
        map.put(anotherUserDeveloper.getEmail(), anotherUserDeveloper);

    }

    @Test
    public void testSendMessageAboutBug() {
        when(userService.getDevelopers()).thenReturn(developers);
        when(messageCreator.createMessage(anyList(), anyString())).thenReturn(message);
        doNothing().when(mailSender).sendMail(message);

        mailService.sendMessageAboutBug();

        verify(userService, times(SINGLE_INVOCATION)).getDevelopers();
        verify(messageCreator, times(SINGLE_INVOCATION)).createMessage(anyList(), anyString());
        verify(mailSender, times(SINGLE_INVOCATION)).sendMail(message);
        verifyNoMoreInteractions(userService, messageCreator, mailSender);
    }

    @Test(expected = RecipientsException.class)
    public void testCheckRecipients() {
        when(userService.getDevelopers()).thenReturn(new ArrayList<>());

        mailService.sendMessageAboutBug();

        verify(userService, times(SINGLE_INVOCATION)).getDevelopers();
        verify(messageCreator, never()).createMessage(anyList(), anyString());
        verify(mailSender, never()).sendMail(message);
        verifyNoMoreInteractions(userService, messageCreator, mailSender);
    }

    @Test
    public void testSendFirstInvitation() {
        String message = LOCAL_MESSAGE_TEXT;

        when(messageCreator.createPersonalMessage(any(User.class), anyString())).thenReturn(message);
        doNothing().when(mailSender).sendMail(message);

        String firstInvitation = mailService.sendFirstInvitation(userDeveloper);
        assertEquals(message, firstInvitation);

        verify(messageCreator, times(SINGLE_INVOCATION)).createPersonalMessage(any(User.class), anyString());
        verify(mailSender, times(SINGLE_INVOCATION)).sendMail(message);
        verifyNoMoreInteractions(messageCreator, mailSender);
    }

    @Test
    public void testSendMeDummyMessagesForAllTopics() {
        User user = new User();
        when(userService.getCurrentUser()).thenReturn(Optional.of(user));
        when(messageCreator.createPersonalMessage(eq(user), anyString())).thenReturn(message);
        doNothing().when(mailSender).sendMail(message);

        mailService.sendMeDummyMessagesForAllTopics();

        verify(mailSender, times(SINGLE_INVOCATION)).sendMail(anyString());
        verify(userService, times(SINGLE_INVOCATION)).getCurrentUser();
        verify(messageCreator, times(Topic.values().length)).createPersonalMessage(eq(user), anyString());
        verifyNoMoreInteractions(mailSender, userService, messageCreator);
    }

    @Test(expected = NoSuchElementException.class)
    public void testSendMeDummyMessagesForAllTopicsException() {
        User user = new User();
        when(userService.getCurrentUser()).thenReturn(Optional.empty());

        mailService.sendMeDummyMessagesForAllTopics();

        verify(userService, times(SINGLE_INVOCATION)).getCurrentUser();
        verify(messageCreator, never()).createPersonalMessage(eq(user), anyString());
        verify(mailSender, never()).sendMail(anyString());
        verifyNoMoreInteractions(mailSender, userService, messageCreator);
    }

    @Test
    public void testGetDeveloperEmails() {

        when(userService.getDevelopers()).thenReturn(developers);

        Assert.assertEquals(mailService.getDeveloperEmails(), map);

        verify(userService, times(SINGLE_INVOCATION)).getDevelopers();
        verifyNoMoreInteractions(mailSender, userService, messageCreator);
    }

    @Test
    public void testGetDeveloperEmailsIfListsIsEmpty() {

        when(userService.getDevelopers()).thenReturn(new ArrayList<>());

        Assert.assertTrue(mailService.getDeveloperEmails().isEmpty());

        verify(userService, times(SINGLE_INVOCATION)).getDevelopers();
        verifyNoMoreInteractions(mailSender, userService, messageCreator);
    }
}