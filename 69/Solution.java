public class Solution {
    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        if (x >= 2147395600)
            return 46340;
        int X = x;
        int r = 1;
        while(X != 0){
            X >>>= 2;
            r <<= 1;
        }
        int r2 = (r + x / r) / 2;
        while (r2 < r){
            System.out.println(r2);
            r = r2;
            r2 = (r + x / r) / 2;
        }
        return r;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.mySqrt(2147395599);
    }
}