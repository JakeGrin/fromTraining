package com.training.sgorodecki.homework.homework23.dao.api;

import com.training.sgorodecki.homework.homework23.entity.Good;

import java.util.List;

public interface GoodDAO {

    List<Good> getAll();

    Good getById(int id);

    List<Good> getGoods(int id);
}

