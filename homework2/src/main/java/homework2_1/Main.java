package homework2_1;

public class Main {

    public static void main(String[] args) {
        int a;
        int p;
        double m1;
        double m2;
        a = Integer.parseInt(args[0]);
        p = Integer.parseInt(args[1]);
        m1 = Double.parseDouble(args[2]);
        m2 = Double.parseDouble(args[3]);
        Calculator calculator = new Calculator();
        calculator.count(a, p, m1, m2);
    }
}