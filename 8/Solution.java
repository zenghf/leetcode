public class Solution {
    public int myAtoi(String str) {
        if (str.length() == 0)
            return 0;
        // INT_MAX (2147483647) or INT_MIN (-2147483648)
        int INT_MAX = 2147483647;
        int INT_MIN = -2147483648;
        int MAX_OVER_10 = 214748364;
        String string_MAX_OVER_10 = "214748364";
        char ZERO = '0';

        int curr = 0;
        for (; curr < str.length(); curr++)
            if (!Character.isWhitespace(str.charAt(curr)))
                break;
        if (curr == str.length())
            return 0;
        boolean positive = true;
        if (str.charAt(curr) == '-'){
            positive = false;
            curr++;
        }
        else if (str.charAt(curr) == '+'){
            curr++;
        }
        if (curr == str.length())
            return 0;

        // ignore successive 0s at the begining;
        while(str.charAt(curr) == '0')
            curr++;

        int digitEnd = curr;
        for (; digitEnd < str.length(); digitEnd++)
            if (!Character.isDigit(str.charAt(digitEnd)))
                break;
        // System.out.println("" + curr + " " + digitEnd);
        int val = 0;
        if (digitEnd - curr > 10){
            if (positive)
                return INT_MAX;
            else
                return INT_MIN;
        }
        else if (digitEnd - curr < 10) {
            for (; curr < digitEnd; curr++){
                char ch = str.charAt(curr);
                val = val * 10 + (ch - ZERO);
            }
        }
        else if (digitEnd - curr == 10){
            boolean safe = false;
            for (int i = 0; i < 9; i++){
                char ch = str.charAt(curr + i);
                if (!safe && ch > string_MAX_OVER_10.charAt(i)){
                    if (positive)
                        return INT_MAX;
                    else
                        return INT_MIN;
                }
                else if (ch < string_MAX_OVER_10.charAt(i))
                    safe = true;
                val = val * 10 + (ch - ZERO);
            }
            char ch = str.charAt(curr + 9);
            // System.out.println(val);
            // System.out.println(ch);
            if (!safe) {
                if (positive && ch >= '7')
                    return INT_MAX;
                if (!positive && ch >= '8')
                    return INT_MIN;
            }
            val = val * 10 + (ch - ZERO);
        }
        if (!positive)
            val = -val;
        return val;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.myAtoi(" 1175109307q7"));
    }
}