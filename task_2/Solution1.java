import static java.lang.Math.abs;

/**
 * @author Andrew Salygin
 */
public class Solution1 {
    public static double f(double x) {
        return x * x + 2 * x + 1;
    }

    public static void main(String[] args) {
       final double A = -2;
       final double B = 2;
       final double EPS = 10e-6;
       double h = 0.1;
       double x0 = A;
       double f0 = f(x0);
       double x1;
       double f1;
       while (abs(h) > EPS) {
           x1 = x0 + h;
           if (x1 > B || x1 < A) {
               break;
           }
           f1 = f(x1);
           if (f1 > f0) {
               h = -h / 4;
           }
           x0 = x1;
           f0 = f1;
       }
        String formattedx0 = String.format("%.5f", x0);
        String formattedf0 = String.format("%.5f", f0);
        System.out.println("x* = " + formattedx0);
        System.out.println("f* = " + formattedf0);
    }
}