package com.training.sgorodecki.homework.homework20.services.impl;

import com.training.sgorodecki.homework.homework20.config.AppConfiguration;
import com.training.sgorodecki.homework.homework20.config.WebConfiguration;
import com.training.sgorodecki.homework.homework20.entity.Good;
import com.training.sgorodecki.homework.homework20.services.api.GoodService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfiguration.class, WebConfiguration.class})
@WebAppConfiguration
public class GoodServiceImplTest {

    @Autowired
    private GoodService goodService;

    @Test
    public void shouldGetAllGoods() {
        Map<Integer, Good> expected = new HashMap<>();

        Good book = new Good();
        book.setName("Book");
        book.setId(1);
        book.setPrice(BigDecimal.valueOf(20.5));

        Good phone = new Good();
        phone.setName("Phone");
        phone.setId(2);
        phone.setPrice(BigDecimal.valueOf(10.0));

        Good tv = new Good();
        tv.setName("TV");
        tv.setId(3);
        tv.setPrice(BigDecimal.valueOf(24.0));

        Good radio = new Good();
        radio.setName("Radio");
        radio.setId(4);
        radio.setPrice(BigDecimal.valueOf(26.8));

        Good table = new Good();
        table.setName("Table");
        table.setId(5);
        table.setPrice(BigDecimal.valueOf(30.4));

        expected.put(1, book);
        expected.put(2, phone);
        expected.put(3, tv);
        expected.put(4, radio);
        expected.put(5, table);

        Map<Integer, Good> actual = goodService.getAll();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetGoodById() {
        Good actual = goodService.getById(1);
        Good expected = new Good();
        expected.setId(1);
        expected.setName("Book");
        expected.setPrice(new BigDecimal("20.5"));

        Assert.assertEquals(expected, actual);
    }
}