public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if (n == 0)
            return "";
        else if (n == 1)
            return strs[0];
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++){
            int l = strs[i].length();
            if (l < minLength)
                minLength = l;
        }
        int k = 0;
        for (; k < minLength; k++){
            boolean terminate = false;
            for (int i = 1; i < n; i++){
                if (strs[i].charAt(k) != strs[0].charAt(k)){
                    terminate = true;
                    break;
                }
            }
            if (terminate)
                break;
        }
        return strs[0].substring(0, k);
    }
}