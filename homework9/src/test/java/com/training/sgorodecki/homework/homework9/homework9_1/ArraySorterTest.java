package com.training.sgorodecki.homework.homework9.homework9_1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArraySorterTest {
    private ArraySorter arraySorter;

    @Before
    public void setUp() {
        arraySorter = new ArraySorter();
    }

    @Test
    public void sortArrayTest() throws Exception {
        Integer[] numbers = new Integer[]{9, 12, 10, 70, 13};
        Integer[] expected = {10, 12, 13, 70, 9};
        Integer[] actual = arraySorter.sortArray(numbers);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void sortEmptyArrayTest() throws Exception {
        Integer[] numbers = new Integer[]{};
        arraySorter.sortArray(numbers);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void sortNullArrayTest() throws Exception {
        Integer[] numbers = null;
        arraySorter.sortArray(numbers);
    }
}