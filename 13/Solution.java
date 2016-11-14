public class Solution {
    public int romanToInt(String s) {
        // char[] c = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        String b = "IVXLCDM";
        int[] n = {1, 5, 10, 50, 100, 500, 1000};
        int prev = 0, curr = 0, num = 0;
        for (char c : s.toCharArray()){
            curr = n[b.indexOf(c)];
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