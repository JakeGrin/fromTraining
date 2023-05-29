package com.training.sgorodecki.homework.homework22.dao.impl;

import com.training.sgorodecki.homework.homework22.dao.api.GoodDAO;
import com.training.sgorodecki.homework.homework22.entity.Good;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GoodDAOImpl implements GoodDAO {

    private static final String ID = "id";
    private static final String USERNAME = "username";

    private final SessionFactory sessionFactory;

    public GoodDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Good> getAll(){
        Session session = sessionFactory.getCurrentSession();
        String hql = "from Good";
        Query<Good> query = session.createQuery(hql);
        return query.getResultList();
    }

    @Override
    public Good getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from Good where id = :id";
        Query<Good> query = session.createQuery(hql);
        query.setParameter(ID,id );
        return query.uniqueResult();
    }

    @Override
    public List<Good> getGoods(String username) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT g FROM Good g" +
                " JOIN OrderGood og ON g.id  = og.goodId" +
                " JOIN Order o ON og.orderId = o.id" +
                " JOIN User u ON u.id = o.userId" +
                " WHERE u.login = :username";
        Query<Good> query = session.createQuery(hql);
        query.setParameter(USERNAME, username);
        return query.getResultList();
    }

}
