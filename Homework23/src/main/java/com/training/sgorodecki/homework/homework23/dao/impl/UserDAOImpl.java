package com.training.sgorodecki.homework.homework23.dao.impl;

import com.training.sgorodecki.homework.homework23.dao.api.UserDAO;
import com.training.sgorodecki.homework.homework23.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

    private static final String LOGIN = "login";
    private static final String ID = "id";
    private static final String FROM_USER_WHERE_LOGIN_LOGIN = "from User where login = :login";
    private static final String FROM_USER_WHERE_ID_ID = "from User where id = :id";

    private final SessionFactory sessionFactory;

    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Override
    public User getByLogin(String login) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery(FROM_USER_WHERE_LOGIN_LOGIN);
        query.setParameter(LOGIN, login);
        return query.uniqueResult();
    }

    @Override
    public User getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery(FROM_USER_WHERE_ID_ID);
        query.setParameter(ID, id);
        return query.uniqueResult();
    }
}