public class Solution {
    public double myPow(double x, int n) {
        if (x == 0 && n <= 0)
            throw new RuntimeException("wrong value");
        if (x == 0)
            return 0;
        if (n == 0)
            return 1.0;
        double X = x > 0 ? x : -x;
        double v = Math.exp(Math.log(X) * n);
        if (x < 0 && n % 2 == 1)
            v = -v;
        return v;
    }
}