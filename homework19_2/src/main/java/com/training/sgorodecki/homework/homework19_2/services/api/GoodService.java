package com.training.sgorodecki.homework.homework19_2.services.api;

import com.training.sgorodecki.homework.homework19_2.entity.Good;

public interface GoodService {

    String getAllGoods();

    Good getGoodById(int id);
}
