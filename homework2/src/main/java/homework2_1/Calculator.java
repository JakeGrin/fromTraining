package homework2_1;

import static java.lang.Math.PI;

public class Calculator {

    public static final String ITS_IMPOSSIBLE = "Its Impossible!";
    /**
     *method description - calculation according to given formula.
     *
     * @param  -   variable a; variable p; variable m1, variable m2 are program arguments from command line
     * @result -   variable G is result of calculation
     * If denominator of formula equals null,a warning message will appear
     */
    public double count(int a, int p, double m1, double m2) {
        double G = 0;
        if (((p * p) * (m1 + m2)) != 0) {
            G = (4 * PI * PI * a * a * a) / ((p * p) * (m1 + m2));
          
            System.out.println(G);
        } else {
            System.out.println(ITS_IMPOSSIBLE);
            throw new UnsupportedOperationException(ITS_IMPOSSIBLE);
        }
        return G;
    }
}