public class Solution {
    private static int[] twoPower;
    static {
        twoPower = new int[32];
        int num = 1;
        for (int i = 0; i < 31; i++){
            twoPower[i] = num;
            num = num + num;
        }
    }

    public int divide(int dividend, int divisor) {
        if (divisor == 0)
            return Integer.MAX_VALUE;
        if (divisor == 1)
            return dividend;
        if (divisor == -1){
            if (dividend == Integer.MIN_VALUE)
                return Integer.MAX_VALUE;
            else
                return -dividend;
        }
        if (divisor == Integer.MIN_VALUE){
            if (dividend == Integer.MIN_VALUE)
                return 1;
            else
                return 0;
        }
        if (dividend == 0)
            return 0;

        boolean isPositive = (dividend > 0) == (divisor > 0);
        int b = divisor > 0 ? divisor : -divisor;
        int a = 0;
        int a_remain = 0;
        if (dividend == Integer.MIN_VALUE){
            a = Integer.MAX_VALUE - b + 1;
            a_remain = 1;
        }
        else
            a = dividend > 0 ? dividend : -dividend;
        int[] array = new int[32];
        int i = 0;
        int num = b;
        while(num <= a){
            array[i++] = num;
            if (num >= 1073741824)
                break;
            num = num + num;
        }
        // for (int j = 0; j < 32; j++)
        //     System.out.println("" + j + " " + array[j]);
        // i--;
        while(i >= 0 && array[i] == 0)
            i--;
        int res = 0;
        for(; i >= 0 && a > 0 ; i--){
            if (a >= array[i]){
                // System.out.println("" + i + " " + a + " " + array[i] + " " + twoPower[i]);
                res += twoPower[i];
                a = a - array[i];
            }
        }
        res = res + a_remain;
        if (isPositive)
            return res;
        else
            return -res;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.divide(2, 2));
    }
}