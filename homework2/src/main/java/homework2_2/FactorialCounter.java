package homework2_2;

public class FactorialCounter {

    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final int ZERO = 0;
    public static final String NOT_APPROPRIATE_VALID = "Not appropriate valid";
    public static final String ERROR_NUMBER_MUST_BE_POSITIVE = "Error!Number must be positive";

    public int count(int loopType, int number) {
        int fact = 1;
        if (loopType != ONE && loopType != TWO && loopType != THREE) {
            System.out.println(NOT_APPROPRIATE_VALID);
        } else {
            if (number < ZERO) {
                System.out.println(ERROR_NUMBER_MUST_BE_POSITIVE);
                throw new UnsupportedOperationException(ERROR_NUMBER_MUST_BE_POSITIVE);
            } else if (number == ZERO) {
                System.out.println(1);
                return fact;
            } else if (number > ZERO) {
                int i = 0;
                if (loopType == ONE) {
                    while (i < number) {
                        fact = fact * (number - i);
                        i++;
                    }
                } else if (loopType == TWO) {
                    do {
                        fact = fact * (number - i);
                        i++;
                    }
                    while (i < number);
                } else if (loopType == THREE) {
                    for (i = 0; i < number - 1; i++) {
                        fact = fact * (number - i);
                    }
                }
                System.out.println(fact);
            }
        }
        return fact;
    }
}