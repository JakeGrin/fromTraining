package com.training.sgorodecki.homework.homework22.dao.impl;

import com.training.sgorodecki.homework.homework22.dao.api.UserDAO;
import com.training.sgorodecki.homework.homework22.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDAOImpl implements UserDAO {

    private static final String LOGIN = "login";

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
        String hql = "from User where login = :login";
        Query<User> query = session.createQuery(hql);
        query.setParameter(LOGIN, login);
        return query.uniqueResult();
    }
}