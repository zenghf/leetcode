public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int d = 1;
        while (x / d >= 10)
            d *= 10;

        while(x > 0){
            if (x / d != x % 10)
                return false;
            x = (x - x / d * d)  / 10;
            d = d / 100;
        }
        return true;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(121));
    }
}