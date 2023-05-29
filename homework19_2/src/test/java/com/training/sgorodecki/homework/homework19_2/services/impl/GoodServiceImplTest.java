package com.training.sgorodecki.homework.homework19_2.services.impl;

import com.training.sgorodecki.homework.homework19_2.entity.Good;
import com.training.sgorodecki.homework.homework19_2.services.api.GoodService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class GoodServiceImplTest {

    @Autowired
    private GoodService goodService;


    @Test
    public void shouldGetAllGoods() {

        String expected = "<option name=\"id\" value=1>Book 20.5 $</option>" +
                "<option name=\"id\" value=2>Phone 10.0 $</option>" +
                "<option name=\"id\" value=3>TV 24.0 $</option>" +
                "<option name=\"id\" value=4>Radio 26.8 $</option>" +
                "<option name=\"id\" value=5>Table 30.4 $</option>";

        String actual = goodService.getAllGoods();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetGoodById() {

        Good actual = goodService.getGoodById(1);
        Good expected = new Good();
        expected.setId(1);
        expected.setName("Book");
        expected.setPrice(new BigDecimal("20.5"));

        Assert.assertEquals(expected, actual);
    }
}