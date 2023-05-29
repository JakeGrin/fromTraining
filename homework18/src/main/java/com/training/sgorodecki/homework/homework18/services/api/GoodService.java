package com.training.sgorodecki.homework.homework18.services.api;

import com.training.sgorodecki.homework.homework18.entity.Good;

public interface GoodService {

    String getAll();

    Good getById(int id);
}
