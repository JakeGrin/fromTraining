package com.training.sgorodecki.homework.homework19_2.dao.api;

import com.training.sgorodecki.homework.homework19_2.entity.Good;

import java.util.List;

public interface GoodDAO {

   List<Good> getAllGoods();

   Good getGoodById(int id);
}
