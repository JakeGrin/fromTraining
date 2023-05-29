package com.training.sgorodecki.homework.homework19_3.dao.api;

import com.training.sgorodecki.homework.homework19_3.entity.Good;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface GoodDAO {

   List<Good> getAllGoods();

   Good getGoodById(int id);
}
