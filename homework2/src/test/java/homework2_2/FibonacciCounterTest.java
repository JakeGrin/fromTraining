package homework2_2;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciCounterTest {
    private FibonacciCounter fibonacciCounter = new FibonacciCounter();

    @Test
    public void testFiboPositive() {

        int[] expected = {0, 1, 1, 2};
        int loopType = 2;
        int number = 4;
        int[] actual = fibonacciCounter.count(loopType, number);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFiboPositiveForOneNumber() {

        int[] expected = {0};
        int loopType = 1;
        int number = 1;
        int[] actual = fibonacciCounter.count(loopType, number);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFiboPositiveForTwoNumber() {

        int[] expected = {0, 1};
        int loopType = 3;
        int number = 2;
        int[] actual = fibonacciCounter.count(loopType, number);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFiboLoopTypeNotValid() {

        int[] expected = {0, 1, 1, 2, 3, 5};
        int loopType = 4;
        int number = 6;
        int[] actual = fibonacciCounter.count(loopType, number);
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void testFiboNumberNotValid() {

        int[] expected = {0, 1, 1, 2, 3, 5};
        int loopType = 1;
        int number = -6;
        int[] actual = fibonacciCounter.count(loopType, number);
        Assert.assertNotEquals(expected, actual);
    }
}