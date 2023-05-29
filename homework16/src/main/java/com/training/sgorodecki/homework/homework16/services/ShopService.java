package com.training.sgorodecki.homework.homework16.services;

import com.training.sgorodecki.homework.homework16.model.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ShopService {

    private Map<Integer, Product> goods;

    public ShopService() {
        this.goods = new HashMap<>();
        goods.put(1, new Product("Book", 1, BigDecimal.valueOf(20.5)));
        goods.put(2, new Product("Phone", 2, BigDecimal.valueOf(10)));
        goods.put(3, new Product("TV", 3, BigDecimal.valueOf(24)));
        goods.put(4, new Product("Radio", 4, BigDecimal.valueOf(26.8)));
        goods.put(5, new Product("Table", 5, BigDecimal.valueOf(30.4)));
    }

    public Map<Integer, Product> getGoods() {
        return goods;
    }

    public void setGoods(Map<Integer, Product> goods) {
        this.goods = goods;
    }

    public String makeGoodsList() {
        return getGoods().entrySet()
                .stream()
                .map(entry -> "<option name=\"id\" value=" + entry.getKey() + ">" + entry.getValue().toString() + "</option>")
                .collect(Collectors.joining());
    }
}
