public class Solution {
    public String longestPalindrome1(String s) {
        if (s.length() == 0)
            return "";
        if (s.length() == 1)
            return new String(s);
        int n = s.length();
        int indStart = 0;
        int indEnd = 1;
        int maxLen = 1;
        for (int i = 0; i < n; i++){
            int j = 0;
            for (; i + j + 1 < n && i - j >= 0 && s.charAt(i + j + 1) == s.charAt(i - j); j++);
            int lenEven = j * 2;
            if (lenEven > maxLen) {
                maxLen = lenEven;
                indStart = i - j + 1;
                indEnd = i + j + 1;
            }
            j = 0;
            for (; i + j + 1 < n && i - j - 1 >= 0 && s.charAt(i + j + 1) == s.charAt(i - j -1); j++);
            int lenOdd = j * 2 + 1;
            if (lenOdd > maxLen){
                maxLen = lenOdd;
                indStart = i - j;
                indEnd = i + j + 1;
            }

        }
        return s.substring(indStart, indEnd);
    }

    public String longestPalindrome(String s) {
        if (s.length() < 2)
            return new String(s);
        int n = s.length();
        int indStart = 0;
        int indEnd = 1;
        int maxLen = 1;
        for (int i = 0; i < n;){
            int j = i;
            char c = s.charAt(i);
            do {
                i++;
            }
            while (i < n && s.charAt(i) == c);
            int k = i;
            while (j - 1 >= 0  && k < n && s.charAt(j - 1) == s.charAt(k)) {
                j--;
                k++;
            }
            int len = k - j;
            if (len > maxLen) {
                maxLen = len;
                indStart = j;
                indEnd = k;
            }
        }
        return s.substring(indStart, indEnd);
    }

    public static void main(String[] args){
        String s = "abcbadefgh";
        Solution sol = new Solution();
        System.out.println(sol.longestPalindrome(s));
    }
}