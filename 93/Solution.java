import java.util.*;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        int len = s.length();
        if (len < 4 || len > 12)
            return res;
        backtrack(res, s, new StringBuilder(), 0, 4);
        return res;
    }

    public void backtrack(List<String> res, String s, StringBuilder sb, int start, int remain){
        System.out.println("" + remain + " " + start + " " + sb.toString() );
        int N = s.length();
        remain--;
        if (remain == 0){
            int n = 0;
            for (int i = start; i < N; i++){
                n = n * 10 + (s.charAt(i) - '0');
                if (n == 0 && i < N - 1)
                    return;
                if (n >= 256)
                    break;
            }
            if (n < 256){
                sb.append(n);
                res.add(sb.toString());
            }
            return;
        }
        int n = 0;
        System.out.println("  start: " + start + " " + (N - start - 1) + " [" + remain + " " + (3 * remain) + "]");
        for (int i = start; i < start + 3 && N - i - 1 >= remain; i++){
            System.out.println("  i: " + i);
            n = n * 10 + (s.charAt(i) - '0');
            if (N - i - 1 <= 3 * remain && n < 256){
                StringBuilder sb1 = new StringBuilder();
                sb1.append(sb);
                sb1.append(n);
                sb1.append('.');
                // System.out.println(sb1);
                backtrack(res, s, sb1, i + 1, remain);
            }
            if (n >= 256 || n == 0)
                break;
        }
    }

    public static void main(String[] args){
        String s = "19216811";
        Solution solution = new Solution();
        System.out.println(solution.restoreIpAddresses(s));
    }
}