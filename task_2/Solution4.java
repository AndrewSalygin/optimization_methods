/**
 * @author Andrew Salygin
 */
public class Solution4 {
    public static double f(double x) {
        return x * x * x + 3 * x * x - 3 * x + 1;
    }

    public static void main(String[] args) {
        final double EPS = 10e-6;
        double a = -1;
        double b = 2;
        double x1 = a;
        double x2 = (a + b) / 2;
        double x3 = b;
        double f1 = f(x1);
        double f2 = f(x2);
        double f3 = f(x3);
        double a1, a2;
        double xLine, fXLine, deltaX, xPred = 0;
        do {
            a1 = (f2 - f1) / (x2 - x1);
            a2 = (1 / (x3 - x2)) * (((f3 - f1) / (x3 - x1)) - (f2 - f1) / (x2 - x1));
            xLine = 0.5 * (x1 + x2 - (a1 / a2));
            fXLine = f(xLine);
            if (fXLine > f2) {
                if (xLine < x2) {
                    x1 = xLine;
                    f1 = fXLine;
                }
                else {
                    x3 = xLine;
                    f3 = fXLine;
                }
            } else {
                if (xLine < x2) {
                    x3 = x2;
                    f3 = f2;
                }
                else {
                    x1 = x2;
                    f1 = f2;
                }
                x2 = xLine;
                f2 = fXLine;
            }
            deltaX = Math.abs(xLine - xPred);
            xPred = xLine;
        } while (deltaX > EPS);
        String formattedXStar = String.format("%.5f", xLine);
        String formattedFStar = String.format("%.5f", fXLine);
        System.out.println(formattedXStar);
        System.out.println(formattedFStar);
    }
}
