/**
 * @author Andrew Salygin
 */
public class Solution2 {
    public static double f(double x) {
        return x * x + 2 * x + 1;
    }

    public static void main(String[] args) {
        final double DELTA = 2e-7;
        final double EPS = 10e-6;
        double a = -2;
        double b = 2;
        double x1;
        double f1;
        double x2;
        double f2;
        while ((b - a) / 2 > EPS) {
            x1 = (a + b - DELTA) / 2;
            x2 = (a + b + DELTA) / 2;
            f1 = f(x1);
            f2 = f(x2);
            if (f2 > f1) {
                b = x2;
            } else {
                a = x1;
            }
        }

        String formattedXStar = String.format("%.5f", (a + b) / 2);
        String formattedFStar = String.format("%.5f", f((a + b) / 2));
        System.out.println("x* = " + formattedXStar);
        System.out.println("f* = " + formattedFStar);
    }
}
