package homework2_1;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    private static final double DELTA = 0.01d;
    private Calculator calculator = new Calculator();

    @Test
    public void testCountPositive() {
        double expected = 0.10d;
        int a = 1;
        int p = 4;
        double m1 = 22.2d;
        double m2 = 2.3d;
        double actual = calculator.count(a, p, m1, m2);
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testCountNegative() {
        int a = 1;
        int p = 0;
        double m1 = 22.2d;
        double m2 = 2.3d;
       calculator.count(a, p, m1, m2);
    }
}