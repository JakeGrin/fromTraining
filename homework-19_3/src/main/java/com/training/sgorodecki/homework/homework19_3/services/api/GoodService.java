package com.training.sgorodecki.homework.homework19_3.services.api;

import com.training.sgorodecki.homework.homework19_3.entity.Good;

public interface GoodService {

    String getAllGoods();

    Good getGoodById(int id);
}
