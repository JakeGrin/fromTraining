package homework2_2;

import java.util.Arrays;

public class FibonacciCounter {

    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final int ZERO = 0;
    public static final String NOT_APPROPRIATE_VALID = "Not appropriate valid";
    public static final String STRING_ZERO = "0";
    public static final String STRING_ZERO_ONE = "0 1";
    public static final String ERROR_NUMBER_MUST_BE_POSITIVE = "Error!Number must be positive";

    public int[] count(int loopType, int number) {
        int[] fibo = new int[0];
        if (loopType != ONE && loopType != TWO && loopType != THREE) {
            System.out.println(NOT_APPROPRIATE_VALID);
        } else {
            if (number == ONE) {
                fibo = new int[]{0};
                System.out.println(STRING_ZERO);
                return fibo;
            } else if (number == TWO) {
                fibo = new int[]{0, 1};
                System.out.println(STRING_ZERO_ONE);
                return fibo;
            } else if (number <= ZERO) {
                System.out.println(ERROR_NUMBER_MUST_BE_POSITIVE);
            } else if (number > TWO) {
                fibo = new int[number];
                fibo[0] = 0;
                fibo[1] = 1;
                int i = 2;
                if (loopType == ONE) {
                    while (i < fibo.length) {
                        fibo[i] = fibo[i - 1] + fibo[i - 2];
                        i++;
                    }
                } else if (loopType == TWO) {
                    do {
                        fibo[i] = fibo[i - 1] + fibo[i - 2];
                        i++;
                    } while (i < fibo.length);
                } else if (loopType == THREE) {
                    for (i = 2; i < fibo.length; i++) {
                        fibo[i] = fibo[i - 1] + fibo[i - 2];
                    }
                }
            }
            System.out.println(Arrays.toString(fibo));
        }
        return fibo;
    }
}