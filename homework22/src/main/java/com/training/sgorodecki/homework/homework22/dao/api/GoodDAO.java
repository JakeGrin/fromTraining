package com.training.sgorodecki.homework.homework22.dao.api;

import com.training.sgorodecki.homework.homework22.entity.Good;

import java.util.List;

public interface GoodDAO {

    List<Good> getAll();

    Good getById(int id);

    List<Good> getGoods(String username);
}

