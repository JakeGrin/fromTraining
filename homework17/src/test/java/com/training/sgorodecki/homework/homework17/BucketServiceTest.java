package com.training.sgorodecki.homework.homework17;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.training.sgorodecki.homework.homework17.model.Product;
import com.training.sgorodecki.homework.homework17.services.BucketService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class BucketServiceTest {

    private BucketService bucketService;

    @Before
    public void setUp() {
        bucketService = new BucketService();
    }

    @Test
    public void makeUserBucketTest() {
        String username1 = "Jonathan";
        Product pen = new Product("pen", 1, BigDecimal.valueOf(2.5));
        Product pencil = new Product("pencil", 2, BigDecimal.valueOf(1.5));
        Multimap<String, Product> multimap = ArrayListMultimap.create();
        multimap.put(username1, pen);
        multimap.put(username1, pencil);
        bucketService.setMultimap(multimap);
        String expected = "<li>pen 2.5 $</li><li>pencil 1.5 $</li>";
        String actual = bucketService.makeUserBucket(username1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void makeTotalCostTest() {
        String username1 = "Jonathan";
        Product pen = new Product("pen", 1, BigDecimal.valueOf(2.5));
        Product pencil = new Product("pencil", 2, BigDecimal.valueOf(1.5));
        Multimap<String, Product> multimap = ArrayListMultimap.create();
        multimap.put(username1, pen);
        multimap.put(username1, pencil);
        bucketService.setMultimap(multimap);
        BigDecimal expected = BigDecimal.valueOf(4.0);
        BigDecimal actual = bucketService.makeTotalCost(username1);
        Assert.assertEquals(expected, actual);
    }
}