import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return new ArrayList<String>();
        int len = digits.length();
        int N = 1;
        for(char c: digits.toCharArray()){
            if (c > '9' || c < '2')
                throw new RuntimeException();
            int n = 3;
            if (c == '9' || c == '7')
                n = 4;
            N *= n;
        }
        char[][] chars = new char[N][];
        for (int i = 0; i < N; i++)
            chars[i] = new char[digits.length()];
        int blocksize = N;
        for(int k = 0; k < digits.length(); k++){
            char c = digits.charAt(k);
            int n = 3;
            if (c == '9' || c == '7')
                n = 4;
            char[] dic = new char[n];
            char cStart = (char)('a' + 3  * (c - '2'));
            if (c > '7')
                cStart = (char)(cStart + 1);
            for (int i = 0; i < n; i++)
                dic[i] = (char)(cStart + i);
            blocksize /= n;
            int j = 0;
            int jj = 0;
            for (int i = 0; i < N; i++){
                chars[i][k] = dic[j];
                jj++;
                if (jj >= blocksize){
                    jj = 0;
                    j++;
                    if (j >= n)
                        j = 0;
                }
            }
        }

        ArrayList<String> res = new ArrayList<>();
        for (char[] cs : chars){
            res.add(new String(cs));
        }
        return res;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String digits = "23";
        List<String> strs = solution.letterCombinations(digits);
        System.out.println(strs);
    }
}