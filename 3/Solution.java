public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        // if the current character is c, the index of the last seen of c, -1 if this is the first occurence of the of c
        int[] prev = new int[n];
        // the index of last seen c
        int[] prev_ind = new int[256];
        for (int i = 0; i < 256; i++)
            prev_ind[i] = -1;
        for (int i = 0; i < n; i++){
            int c = (int) s.charAt(i);
            prev[i] = prev_ind[c];
            prev_ind[c] = i;
        }
        int max_len = 0;
        for (int i = n - 1; i >= 0; i--){
            int max_prev = prev[i];
            int len = i - max_prev;
            if (len <= max_len)
                continue;
            for (int j = i - 1; j > max_prev; j--){
                if (prev[j] > max_prev)
                    max_prev = prev[j];
            }
            len = i - max_prev;
            if (len > max_len)
                max_len = len;
        }
        return max_len;
    }

    public static void main(String[] args){
        String s = "abcabcbb";
        Solution sol = new Solution();
        int l = sol.lengthOfLongestSubstring(s);
        System.out.println(l);
    }
}