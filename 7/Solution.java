public class Solution {
    public int reverse(int x) {
        if (x == -2147483648)
            return 0;

        // MAX_INT = 2147483647
        // MIN_INT = -2147483648
        boolean negative = x < 0;
        if (x < 0)
            x = -x;
        int [] max = {2, 1, 4, 7, 4, 8, 3, 6, 4, 7};
        int [] xlist = new int[10];
        if (negative)
            max[9] = 8;
        int k = 9;
        for (int i = 0; i < 10; i++){
            xlist[i] = x % 10;
            x = x / 10;
            if (x == 0){
                k = i;
                break;
            }
        }

        if (k == 9){
            for (int i = 0; i < 10; i++){
                int d = xlist[i] - max[i];
                if (d < 0)
                    break;
                if (d > 0)
                    return 0;
            }
        }

        int invx = 0;
        int [] order = {1000000000, 100000000, 10000000, 1000000, 100000, 10000, 1000, 100, 10, 1};
        for (int i = 0; i < k + 1; i++)
            invx += order[9 - k + i] * xlist[i];
        if (negative)
            invx = -invx;

        return invx;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int a = solution.reverse(-2147483412);
        System.out.println(a);
    }
}