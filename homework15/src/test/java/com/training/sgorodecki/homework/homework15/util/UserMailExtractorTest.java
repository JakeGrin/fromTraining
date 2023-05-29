package com.training.sgorodecki.homework.homework15.util;

import com.training.sgorodecki.homework.homework15.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserMailExtractorTest {
    private static final String EMAIL_FOR_USER = "saab@ntv.by";
    private static final String EMAIL_FOR_ANOTHER_USER = "porshe@rtr.ru";
    private User user;
    private User anotherUser;
    private List<User> users;
    private List<String> mails;

    @Before
    public void setUp() {
        user = new User();
        anotherUser = new User();
        users = new ArrayList<>();
        mails = new ArrayList<>();
        user.setEmail(EMAIL_FOR_USER);
        anotherUser.setEmail(EMAIL_FOR_ANOTHER_USER);
        mails.add(user.getEmail());
        mails.add(anotherUser.getEmail());
    }

    @Test
    public void getMailsFromUsers() {
        users.add(user);
        users.add(anotherUser);

        Assert.assertEquals(UserMailExtractor.getMailsFromUsers(users), mails);
    }

    @Test
    public void getMailsFromUsersIfUserListIsEmpty() {
        Assert.assertTrue(UserMailExtractor.getMailsFromUsers(users).isEmpty());
    }
}