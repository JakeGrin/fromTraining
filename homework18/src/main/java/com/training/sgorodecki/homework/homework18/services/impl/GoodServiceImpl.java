package com.training.sgorodecki.homework.homework18.services.impl;

import com.training.sgorodecki.homework.homework18.dao.api.GoodDAO;
import com.training.sgorodecki.homework.homework18.dao.impl.GoodDAOImpl;
import com.training.sgorodecki.homework.homework18.entity.Good;
import com.training.sgorodecki.homework.homework18.util.PageUtil;
import com.training.sgorodecki.homework.homework18.services.api.GoodService;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GoodServiceImpl implements GoodService {

    private static GoodServiceImpl instance;

    private final GoodDAO goodDAO = new GoodDAOImpl();

    public static synchronized GoodServiceImpl getInstance() {
        if (instance == null) {
            instance = new GoodServiceImpl();
        }
        return instance;
    }

    public GoodServiceImpl() {
    }

    @Override
    public String getAll() {
        Map<Integer, Good> collect = goodDAO.getAll()
                .stream()
                .collect(Collectors.toMap(Good::getId, Function.identity()));

        return PageUtil.makeDropDownList(collect);
    }

    @Override
    public Good getById(int id) {
        return goodDAO.getById(id);
    }
}