package com.training.sgorodecki.homework.homework19.services.impl;

import com.training.sgorodecki.homework.homework19.Connector;
import com.training.sgorodecki.homework.homework19.dao.api.GoodDAO;
import com.training.sgorodecki.homework.homework19.dao.impl.GoodDAOImpl;
import com.training.sgorodecki.homework.homework19.entity.Good;
import com.training.sgorodecki.homework.homework19.services.PageUtil;
import com.training.sgorodecki.homework.homework19.services.api.GoodService;

import java.util.Map;
import java.util.stream.Collectors;

public class GoodServiceImpl implements GoodService {

    private final GoodDAO goodDAO;

    public GoodServiceImpl(GoodDAO goodDAO) {
        this.goodDAO = goodDAO;
    }

    @Override
    public String getAllGoods() {
        Map<Integer, Good> collect = goodDAO.getAllGoods()
                .stream()
                .collect(Collectors.toMap(Good::getId, good -> good));

        return PageUtil.makeDropDownList(collect);
    }

    @Override
    public Good getGoodById(int id) {
        return goodDAO.getGoodById(id);
    }
}