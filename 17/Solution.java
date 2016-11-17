import java.util.ArrayList;
import java.util.List;

public class Solution {
    private char[][] mapping = new char[][]{{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    public List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<>();
        if (digits.isEmpty())
            return result;
        char[] charDigits = digits.toCharArray();
        char[] charString = new char[digits.length()];
        dfs(charString, charDigits, result, 0);
        return result;
    }

    private void dfs(char[] charString, char[] charDigits, ArrayList<String> result, int ind){
        int d = charDigits[ind] - '2';
        for (char c : mapping[d]){
            charString[ind] = c;
            if (ind == charDigits.length - 1)
                result.add(new String(charString));
            else
                dfs(charString, charDigits, result, ind + 1);
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String digits = "23";
        List<String> strs = solution.letterCombinations(digits);
        System.out.println(strs);
    }
}