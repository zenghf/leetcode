public class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        // case 0;
        if (n == 0)
            return new int[]{1};
        int indFirstNon9 = n - 1;
        while(indFirstNon9 >= 0 && digits[indFirstNon9] == 9)
            indFirstNon9--;
        if (indFirstNon9 == -1){
            int[] result = new int[n + 1];
            result[0] = 1;
            return result;
        }
        else{
            int[] result = new int[n];
            int i = 0;
            for (; i < indFirstNon9; i++)
                result[i] = digits[i];
            result[i] = digits[i] + 1;
            for(i = indFirstNon9 + 1; i < n; i++)
                result[i] = 0;
            return result;
        }
    }
}