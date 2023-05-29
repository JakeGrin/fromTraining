package com.training.sgorodecki.homework.homework23.services.api;

import com.training.sgorodecki.homework.homework23.entity.Good;

import java.util.Map;

public interface GoodService {

    Map<Integer, Good> getAll();

    Good getById(int id);
}
