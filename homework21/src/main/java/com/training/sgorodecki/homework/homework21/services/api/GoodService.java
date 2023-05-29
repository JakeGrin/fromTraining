package com.training.sgorodecki.homework.homework21.services.api;

import com.training.sgorodecki.homework.homework21.entity.Good;

import java.util.Map;

public interface GoodService {

    Map<Integer, Good> getAll();

    Good getById(int id);
}
