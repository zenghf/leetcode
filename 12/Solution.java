public class Solution {
    public String intToRoman(int num) {
        char[][] s = {{'I', 'V'}, {'X', 'L'}, {'C', 'D'}, {'M', ' '}};
        String r = "";
        int k = 0;
        while (num > 0){
            int d = num % 10;
            if (d == 9)
                r = "" + s[k][0] + s[k + 1][0] + r;
            else if (d == 4)
                r = "" + s[k][0] + s[k][1] + r;
            else {
                for (int i = 0; i < d % 5; i++)
                    r = "" + s[k][0] + r;
                for (int i = 0; i < d / 5; i++)
                    r = "" + s[k][1] + r;
            }
            num = num / 10;
            k++;
        }
        return r;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int num = 3999;
        // System.out.println('I' + 'B');
        System.out.println(solution.intToRoman(num) + " : " + num);
    }
}