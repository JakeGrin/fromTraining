package com.training.sgorodecki.homework.homework20.services.impl;

import com.training.sgorodecki.homework.homework20.dao.api.GoodDAO;
import com.training.sgorodecki.homework.homework20.entity.Good;
import com.training.sgorodecki.homework.homework20.services.api.GoodService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class GoodServiceImpl implements GoodService {

    private final GoodDAO goodDAO;

    public GoodServiceImpl(GoodDAO goodDAO) {
        this.goodDAO = goodDAO;
    }

    @Override
    public Map<Integer, Good> getAll() {

        return goodDAO.getAll()
                .stream()
                .collect(Collectors.toMap(Good::getId, Function.identity()));
    }

    @Override
    public Good getById(int id) {
        return goodDAO.getById(id);
    }
}