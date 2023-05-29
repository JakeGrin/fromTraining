package com.training.sgorodecki.homework.homework19.services.api;

import com.training.sgorodecki.homework.homework19.entity.Good;

public interface GoodService {

    String getAllGoods();

    Good getGoodById(int id);
}
