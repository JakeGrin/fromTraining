package com.training.sgorodecki.homework.homework18.services.impl;

import com.training.sgorodecki.homework.homework18.util.Connector;
import com.training.sgorodecki.homework.homework18.entity.Good;
import com.training.sgorodecki.homework.homework18.services.api.GoodService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class GoodServiceImplTest {

    private GoodService goodService;

    @Before
    public void setUp() {
        goodService = GoodServiceImpl.getInstance();
        Connector connector = Connector.getConnectorInstance();
        connector.initConnection();
    }

    @Test
    public void shouldGetAllGoods() {

        String expected = "<option name=\"id\" value=1>Book 20.5 $</option>" +
                "<option name=\"id\" value=2>Phone 10.0 $</option>" +
                "<option name=\"id\" value=3>TV 24.0 $</option>" +
                "<option name=\"id\" value=4>Radio 26.8 $</option>" +
                "<option name=\"id\" value=5>Table 30.4 $</option>";

        String actual = goodService.getAll();
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