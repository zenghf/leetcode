public class Solution {
    public int findNthDigit(int n) {
        int nDigit = 1;
        int base = 1;
        while (nDigit < 9 && n > nDigit * base * 9){
            System.out.println("nDigit: " + nDigit + " base: " + base + " n: " + n);
            n -= nDigit * base * 9;
            nDigit++;
            base *= 10;
        }
        System.out.println("nDigit: " + nDigit + " base: " + base + " n: " + n);
        n--;
        int ind = n / nDigit;
        int r = n % nDigit;
        int num = base + ind;
        for (int i = 0; i < r; i++)
            base /= 10;
        num /= base;
        return (int) (num % 10);
    }

    public static void main(String[] args){
        System.out.println(Integer.MAX_VALUE);
        int n = Integer.MAX_VALUE;// 1111111111;
        Solution solution = new Solution();
        int res = solution.findNthDigit(n);
        System.out.println(res);
    }
}