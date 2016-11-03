public class Solution {
    public int myAtoi(String str) {
        // INT_MAX (2147483647) or INT_MIN (-2147483648)
        int INT_MAX = 2147483647;
        int INT_MIN = -2147483648;
        int MAX_OVER_10 = 214748364;
        char ZERO = '0';
        String s = str.trim();
        if (s.length() == 0)
            return 0;
        int minus = 1;
        int curr = 0;
        if (s.charAt(0) == '-'){
            minus = -1;
            curr = 1;
        }
        else if (s.charAt(0) == '+'){
            curr = 1;
        }
        int val = 0;

        for (; curr < s.length(); curr++){
            char ch = s.charAt(curr);
            if (!Character.isDigit(ch))
                break;
            if (val < MAX_OVER_10)
                val = val * 10 + (ch - ZERO);
            else if (val == MAX_OVER_10){
                if (minus == 1) {
                    if (ch < '7')
                        return val * 10 + (ch - ZERO);
                    else
                        return INT_MAX;
                }
                else {
                    if (ch < '8')
                        return -(val * 10 + (ch - ZERO));
                    else
                        return INT_MIN;
                }
            }
            else {
                if (minus == 1)
                    return INT_MAX;
                else
                    return INT_MIN;
            }
        }
        return val * minus;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("-100"));
    }
}