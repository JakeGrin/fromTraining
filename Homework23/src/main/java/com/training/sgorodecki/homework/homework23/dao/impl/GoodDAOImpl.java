package com.training.sgorodecki.homework.homework23.dao.impl;

import com.training.sgorodecki.homework.homework23.dao.api.GoodDAO;
import com.training.sgorodecki.homework.homework23.entity.Good;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GoodDAOImpl implements GoodDAO {

    private static final String ID = "id";
    private static final String FROM_GOOD = "from Good";
    private static final String FROM_GOOD_WHERE_ID_ID = "from Good where id = :id";
    private static final String SELECT_GET_GOODS = "select g from Order o JOIN o.goods g WHERE o.id = :id";

    private final SessionFactory sessionFactory;

    public GoodDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Good> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Good> query = session.createQuery(FROM_GOOD);
        return query.getResultList();
    }

    @Override
    public Good getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Good> query = session.createQuery(FROM_GOOD_WHERE_ID_ID);
        query.setParameter(ID, id);
        return query.uniqueResult();
    }

    @Override
    public List<Good> getGoods(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Good> query = session.createQuery(SELECT_GET_GOODS);
        query.setParameter(ID, id);
        return query.getResultList();
    }
}