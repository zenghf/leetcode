import java.util.ArrayList;

public class Solution {
    private static final double Phi = (1.0 + Math.sqrt(5)) / 2.0;
    private static final double phi = (1.0 - Math.sqrt(5)) / 2.0;
    private static final double sqrt5 = Math.sqrt(5);


    public int climbStairs(int n) {
        n = n + 1;
        return (int) Math.round((Math.pow(Phi, n) - Math.pow(phi, n)) / sqrt5);
    }
}