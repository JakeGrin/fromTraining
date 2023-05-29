package com.training.sgorodecki.homework.homework17;

import com.training.sgorodecki.homework.homework17.services.ShopService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShopServiceTest {
    private ShopService shopService;

    @Before
    public void setUp() {
        shopService = new ShopService();
    }

    @Test
    public void makeGoodsListTest() {
        String expected = "<option name=\"id\" value=1>Book 20.5 $</option>" +
                "<option name=\"id\" value=2>Phone 10 $</option>" +
                "<option name=\"id\" value=3>TV 24 $</option>" +
                "<option name=\"id\" value=4>Radio 26.8 $</option>" +
                "<option name=\"id\" value=5>Table 30.4 $</option>";
        String actual = shopService.makeGoodsList();
        Assert.assertEquals(expected, actual);
    }
}