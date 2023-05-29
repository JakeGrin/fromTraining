package com.training.sgorodecki.homework.homework21.dao.api;

import com.training.sgorodecki.homework.homework21.entity.Good;

import java.util.List;

public interface GoodDAO {

    List<Good> getAll();

    Good getById(int id);
}

