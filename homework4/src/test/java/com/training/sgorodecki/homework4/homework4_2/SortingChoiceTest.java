package com.training.sgorodecki.homework4.homework4_2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SortingChoiceTest {
    private SortingChoice sortingChoice;
    private int[] array;

    @Before
    public void setUp() {
        sortingChoice = new SortingChoice();
        array = new int[]{-1, 1, 0, 8, 6};
    }

    @Test
    public void testSortingChoice() {
        int[] expected = {-1, 0, 1, 6, 8};
        int[] actual = sortingChoice.sort(array);
        Assert.assertArrayEquals(expected, actual);
    }
}