
public class Solution {
    public int romanToInt(String s) {
        char[] cs = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        // String b = "IVXLCDM";
        int[] n = {1, 5, 10, 50, 100, 500, 1000};
        int[] m = new int[26];
        for (int i = 0; i < 7; i++)
            m[cs[i] - 'A'] = n[i];
        int prev = 0, curr = 0, num = 0;
        for (char c : s.toCharArray()){
            curr = m[c - 'A'];
            if (curr > prev)
                num -= prev;
            else
                num += prev;
            prev = curr;
        }
        num += curr;
        return num;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String s = "DCXXI";
        System.out.println(s + " : " + solution.romanToInt(s));
    }
}