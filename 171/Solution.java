public class Solution {
    public int titleToNumber(String s) {
        int base = 1;
        int num = 0;
        for (int i = s.length() - 1; i >= 0; i--){
            num += base * (s.charAt(i) - 'A' + 1);
            base *= 26;
        }
        return num;
    }
}