import static java.lang.Math.sqrt;

/**
 * @author Andrew Salygin
 */
public class Solution3 {
    public static double f(double x) {
        return x * x + 2 * x + 1;
    }

    public static void main(String[] args) {
        final double EPS = 10e-6;
        final double TAU = (sqrt(5) - 1) / 2;
        final double INV_TAU = 1 - TAU;
        double a = -2;
        double b = 2;
        double epsN = (b - a) / 2;
        double x1 = a + INV_TAU * (b - a);
        double f1 = f(x1);
        double x2 = a + TAU * (b - a);
        double f2 = f(x2);
        while (epsN > EPS) {
            if (f1 < f2) {
                b = x2;
                x2 = x1; // 0.62
                f2 = f1;
                x1 = b - TAU * (b - a);
                f1 = f(x1);
            } else {
                a = x1;
                x1 = x2; // 0.38
                f1 = f2;
                x2 = b - INV_TAU * (b - a);
                f2 = f(x2);
            }
            epsN = TAU * epsN;
        }

        String formattedXStar = String.format("%.5f", (a + b) / 2);
        String formattedFStar = String.format("%.5f", f((a + b) / 2));
        System.out.println("x* = " + formattedXStar);
        System.out.println("f* = " + formattedFStar);
    }
}
