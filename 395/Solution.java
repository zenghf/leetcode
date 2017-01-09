public class Solution {
    public int longestSubstring(String s, int k) {
        // System.out.println(s);
        if (k == 1)
            return s.length();
        if (s.length() < k)
            return 0;
        int[] count = new int[26];
        for (char ch : s.toCharArray())
            count[ch - 'a']++;
        boolean wholeString = true;
        for (int i = 0; i < 26; i++){
            if (count[i] > 0 && count[i] < k){
                wholeString = false;
                break;
            }
        }
        if (wholeString)
            return s.length();
        // System.out.print("[");
        // for (int i = 0; i < 26; i++)
        //     System.out.print(" " + (char)(i + 'a') + ":" + count[i]);
        // System.out.println("]");
        int start = 0, end = 0, maxLen = 0;
        for (; end <= s.length(); end++){
            if (end == s.length() || count[s.charAt(end) - 'a'] < k){
                if (end - start > maxLen && end - start >= k){
                    int len = longestSubstring(s.substring(start, end), k);
                    if (len > maxLen)
                        maxLen = len;
                }
                start = end + 1;
            }
        }
        return maxLen;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String s = "bbaaacbd";
        System.out.println(solution.longestSubstring(s, 3));
    }
}