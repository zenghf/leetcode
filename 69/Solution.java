public class Solution {
    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        // if (x < 0)
        //     throw new Exception();
        if (x >= 2147395600)
            return 46340;
        int X = x;
        int b = 1;
        while(X != 1){
            X >>>= 1;
            b++;
        }
        double res = (1 << (b / 2)) + 0.0;
        double res2 = (x / res + res) / 2.0;
        while(Math.abs(res2 - res) > 0.1){
            res = res2;
            res2 = (x / res + res) / 2.0;
        }
        int sqrt = (int) res2;
        int sqr = sqrt * sqrt;
        if (sqr == x)
            return sqrt;
        else if (sqr < x){
            while( (sqrt + 1) * (sqrt + 1) < x)
                sqrt++;
            return sqrt;
        }
        else {
            while( (sqrt - 1) * (sqrt - 1) > x)
                sqrt--;
            return sqrt;
        }

    }
}