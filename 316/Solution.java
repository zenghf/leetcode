import java.util.Deque;
import java.util.LinkedList;
import java.util.HashSet;

public class Solution {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0)
            return "";
        if (s.length() == 1)
            return s;
        int[] count = new int[26];
        char[] chs = s.toCharArray();
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new LinkedList<>();
        boolean[] flag = new boolean[26];

        for (int i = 0; i < n; i++)
            count[chs[i] - 'a']++;

        for (int i = 0; i < n; i++){
            // System.out.println("" + i + " :" + chs[i]);
            char ch = chs[i];
            if (count[ch - 'a'] == 0)
                continue;
            if (!flag[ch - 'a']){
                while(!stack.isEmpty() && stack.peek() > ch)
                    flag[stack.pop() - 'a'] = false;
                stack.push(ch);
                flag[ch - 'a'] = true;
            }
            if (--count[ch - 'a'] == 0){
                // System.out.println("start to append + " + stack);
                char c = (char) 0;
                while(!stack.isEmpty() && stack.peekLast() <= ch){
                    c = stack.pollLast();
                    flag[c - 'a'] = false;
                    sb.append(c);
                    count[c - 'a'] = 0;
                }
                if (c != ch){
                    sb.append(ch);
                    count[ch - 'a'] = 0;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicateLetters("abacb"));
    }
}