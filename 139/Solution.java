import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int minLength = Integer.MAX_VALUE;
        int maxLength = 0;
        for (String word : wordDict){
            int len = word.length();
            if (len > maxLength)
                maxLength = len;
            if (len < minLength)
                minLength = len;
        }
        int n = s.length();
        boolean[] matched = new boolean[n + 1];
        matched[0] = true;
        for (int i = minLength - 1; i < n; i++){
            System.out.println("i = " + i);
            int start = i - maxLength + 1;
            int end = i - minLength + 1;
            if (start < 0)
                start = 0;
            System.out.println("  start = " + start + " end = " + end);
            for (int j = start; j <= end; j++){
                if (matched[j] && wordDict.contains(s.substring(j, i + 1))){
                    matched[i + 1] = true;
                    break;
                }
            }
        }
        for (int i = 1; i <= n; i++)
            System.out.print(matched[i] ? "+" : "-");
        System.out.println();
        return matched[n];
    }

    // public boolean wordBreak(String s, Set<String> wordDict, int offset) {
    //     if (offset == s.length())
    //         return true;
    //     for (String word : wordDict){
    //         if (s.startsWith(word, offset) && wordBreak(s, wordDict, offset + word.length()))
    //             return true;
    //     }
    //     return false;
    // }


    public static void main(String[] args){
        Solution solution = new Solution();
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        String[] dict = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        // String s = "leetcode";
        // String[] dict = {"leet", "code"};
        HashSet<String> wordDict = new HashSet<String>(Arrays.asList(dict));
        System.out.println(solution.wordBreak(s, wordDict));
    }
}