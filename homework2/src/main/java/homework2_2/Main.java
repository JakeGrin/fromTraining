package homework2_2;

public class Main {

    public static final String NOT_APPROPRIATE_VALID = "Not appropriate valid";
    public static final int ONE = 1;
    public static final int TWO = 2;


    public static void main(String[] args) {
        int algType = Integer.parseInt(args[0]);
        int loopType = Integer.parseInt(args[1]);
        int number = Integer.parseInt(args[2]);
        if (algType != ONE && algType != TWO) {
            System.out.println(NOT_APPROPRIATE_VALID);
        } else if (algType == ONE) {
            FibonacciCounter fibonacciCounter = new FibonacciCounter();
            fibonacciCounter.count(loopType, number);
        } else if (algType == TWO) {
            FactorialCounter factorialCounter = new FactorialCounter();
            factorialCounter.count(loopType, number);
        }
    }
}