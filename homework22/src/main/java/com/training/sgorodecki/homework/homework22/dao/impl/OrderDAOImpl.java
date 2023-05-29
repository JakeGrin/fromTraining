package com.training.sgorodecki.homework.homework22.dao.impl;

import com.training.sgorodecki.homework.homework22.dao.api.OrderDAO;
import com.training.sgorodecki.homework.homework22.entity.Good;
import com.training.sgorodecki.homework.homework22.entity.Order;
import com.training.sgorodecki.homework.homework22.entity.OrderGood;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO {

    private static final String USER_ID = "userId";
    private static final String USERNAME = "username";

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
    public Order getByUserId(int userId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from Order where userId = :userId";
        Query<Order> query = session.createQuery(hql);
        query.setParameter(USER_ID, userId);
        return query.uniqueResult();
    }

    @Override
    public void updatePrice(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.update(order);
    }

    @Override
    public void saveOrderGood(OrderGood orderGood) {
        Session session = sessionFactory.getCurrentSession();
        session.save(orderGood);
    }

//    @Override
//    public List<Good> getGoods(String username) {
//        Session session = sessionFactory.getCurrentSession();
//        String hql = "SELECT g FROM Good g" +
//                " JOIN OrderGood og ON g.id  = og.goodId" +
//                " JOIN Order o ON og.orderId = o.id" +
//                " JOIN User u ON u.id = o.userId" +
//                " WHERE u.login = :username";
//        Query<Good> query = session.createQuery(hql);
//        query.setParameter(USERNAME, username);
//        return query.getResultList();
//    }
}
