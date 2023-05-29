package com.training.sgorodecki.homework4.homework4_2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContextTest {

    private Context context;
    private Sorter sorterBubble;
    private Sorter sorterChoice;
    private int[] array;

    @Before
    public void setUp() {
        context = new Context();
        sorterBubble = new SortingBubble();
        sorterChoice = new SortingChoice();
        array = new int[]{4, 6, 12, 7, 364};
    }

    @Test
    public void testContextBubble() {
        context.setSorter(sorterBubble);
        int[] expected = {4, 6, 7, 12, 364};
        Assert.assertArrayEquals(expected, context.manage(array));
    }

    @Test
    public void testContextChoice() {
        context.setSorter(sorterChoice);
        int[] expected = {4, 6, 7, 12, 364};
        Assert.assertArrayEquals(expected, context.manage(array));
    }
}
