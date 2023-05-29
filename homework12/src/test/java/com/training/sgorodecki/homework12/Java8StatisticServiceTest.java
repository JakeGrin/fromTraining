package com.training.sgorodecki.homework12;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class Java8StatisticServiceTest {

    private StatisticService statisticService;
    private List<Long> numbers;

    @Before
    public void setUp() throws Exception {
        statisticService = new Java8StatisticService();
        numbers = new ArrayList<>();
        numbers.add(1L);
        numbers.add(5L);
        numbers.add(8L);
        numbers.add(3L);
        numbers.add(2L);
        numbers.add(2L);
        numbers.add(2L);
    }

    @Test
    public void testCountEvenNumbers() {
        Assert.assertEquals(14, statisticService.countEvenNumbers(numbers));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testCountEvenNumbersNegative() {
        List<Long> emptyList = new ArrayList<>();
        Assert.assertEquals(0, statisticService.countEvenNumbers(emptyList));
    }

    @Test
    public void testCalculateSquareOfDistinctNumbers() {
        List<Long> expected = new ArrayList<>();
        expected.add(1L);
        expected.add(4L);
        expected.add(9L);
        expected.add(25L);
        expected.add(64L);
        Assert.assertEquals(expected, statisticService.calculateSquareOfDistinctNumbers(numbers));
    }

    @Test
    public void testGroupStringsByLastLetter() {
        Map<Character, List<String>> expected = new HashMap<>();
        List<String> kList = new ArrayList<>();
        kList.add("dark");
        List<String> dList = new ArrayList<>();
        List<String> nList = new ArrayList<>();
        nList.add("kraken");
        expected.put('k', kList);
        expected.put('n', nList);
        expected.put('d', dList);

        Set<List<String>> set = new HashSet<>();
        List<String> firstList = new ArrayList<>();
        firstList.add("Red");
        firstList.add("dark");
        firstList.add("navy");
        firstList.add("");

        List<String> secondList = new ArrayList<>();
        secondList.add("Green");
        secondList.add("blue");
        secondList.add("Pink");
        secondList.add("kraken");

        set.add(firstList);
        set.add(secondList);

        Assert.assertEquals(expected, statisticService.groupStringsByLastLetter(set));
    }
}