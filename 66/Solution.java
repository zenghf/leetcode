public class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        // case 0;
        if (n == 0)
            return new int[]{1};
        int indFirstNon9 = n - 1;
        for (; indFirstNon9 >=0; indFirstNon9--){
            if (digits[indFirstNon9] == 9)
                digits[indFirstNon9] = 0;
            else{
                digits[indFirstNon9]++;
                return digits;
            }
        }

        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
}