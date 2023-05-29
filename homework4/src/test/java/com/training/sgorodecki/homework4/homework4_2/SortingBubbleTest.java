package com.training.sgorodecki.homework4.homework4_2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SortingBubbleTest {
    private SortingBubble sortingBubble;
    private int[] array;

    @Before
    public void setUp() {
        sortingBubble = new SortingBubble();
        array = new int[]{3, 1, 0, -8, 30};
    }

    @Test
    public void testSortingBubble() {
        int[] expected = {-8, 0, 1, 3, 30};
        int[] actual = sortingBubble.sort(array);
        Assert.assertArrayEquals(expected, actual);
    }
}