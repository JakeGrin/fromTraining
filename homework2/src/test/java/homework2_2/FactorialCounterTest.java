package homework2_2;

import org.junit.Assert;
import org.junit.Test;

public class FactorialCounterTest {
    private FactorialCounter factorialCounter = new FactorialCounter();

    @Test
    public void testFactorialCounter() {
        int expected = 6;
        int number = 3;
        int loopType = 1;
        int actual = factorialCounter.count(loopType, number);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFactorialCounterForNull() {
        int expected = 1;
        int number = 0;
        int loopType = 2;
        int actual = factorialCounter.count(loopType, number);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testFactorialCounterForNegative() {
        int number = -3;
        int loopType = 2;
        factorialCounter.count(loopType, number);
    }

    @Test
    public void testFactorialCounterForLoopTypeNotValid() {
        int expected = 6;
        int number = 3;
        int loopType = 0;
        int actual = factorialCounter.count(loopType, number);
        Assert.assertNotEquals(expected, actual);
    }
}