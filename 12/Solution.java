public class Solution {
    public String intToRoman(int num) {
        char[] s = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        StringBuilder r = new StringBuilder();
        int k = 0;
        while (num > 0){
            int d = num % 10;
            if (d % 5 == 4){
                r.append(s[k + d / 5 + 1]);
                r.append(s[k]);
            }
            else {
                for (int i = 0; i < d % 5; i++)
                    r.append(s[k]);
                for (int i = 0; i < d / 5; i++)
                    r.append(s[k + 1]);
            }
            num = num / 10;
            k = k + 2;
        }
        return r.reverse().toString();
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int num = 6;
        // System.out.println('I' + 'B');
        System.out.println(solution.intToRoman(num) + " : " + num);
    }
}