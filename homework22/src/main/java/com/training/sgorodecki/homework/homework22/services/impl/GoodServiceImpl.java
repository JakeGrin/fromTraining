package com.training.sgorodecki.homework.homework22.services.impl;

import com.training.sgorodecki.homework.homework22.dao.api.GoodDAO;
import com.training.sgorodecki.homework.homework22.entity.Good;
import com.training.sgorodecki.homework.homework22.services.api.GoodService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class GoodServiceImpl implements GoodService {

    private final GoodDAO goodDAO;

    public GoodServiceImpl(GoodDAO goodDAO) {
        this.goodDAO = goodDAO;
    }

    @Transactional
    @Override
    public Map<Integer, Good> getAll() {

        return goodDAO.getAll()
                .stream()
                .collect(Collectors.toMap(Good::getId, Function.identity()));
    }

    @Transactional
    @Override
    public Good getById(int id) {
        return goodDAO.getById(id);
    }
}