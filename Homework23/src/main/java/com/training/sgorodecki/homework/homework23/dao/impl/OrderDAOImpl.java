package com.training.sgorodecki.homework.homework23.dao.impl;

import com.training.sgorodecki.homework.homework23.dao.api.OrderDAO;
import com.training.sgorodecki.homework.homework23.entity.Order;
import com.training.sgorodecki.homework.homework23.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDAOImpl implements OrderDAO {

    private static final String ID = "id";
    private static final String USER = "user";
    private static final String FROM_ORDER_WHERE_ID_ID = "from Order where id = :id";
    private static final String FROM_ORDER_WHERE_USER_USER = "from Order where user = :user";

    private final SessionFactory sessionFactory;

    public OrderDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addOrder(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.save(order);
    }

    @Override
    public Order getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Order> query = session.createQuery(FROM_ORDER_WHERE_ID_ID);
        query.setParameter(ID, id);
        return query.uniqueResult();
    }

    @Override
    public Order getByUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        Query<Order> query = session.createQuery(FROM_ORDER_WHERE_USER_USER);
        query.setParameter(USER, user);
        return query.uniqueResult();
    }

    @Override
    public void updateOrder(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.update(order);
    }
}