import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> letterCombinations(String digits) {
        ArrayList<String> prev = new ArrayList<>();
        ArrayList<String> curr = new ArrayList<>();
        prev.add("");
        for(char c: digits.toCharArray()){
            if (c > '9' || c < '2')
                throw new RuntimeException();
            curr = new ArrayList<>();
            int n = 3;
            if (c == '9' || c == '7')
                n = 4;
            char cStart = (char)('a' + 3  * (c - '2'));
            if (c > '7')
                cStart = (char)(cStart + 1);
            for (int i = 0; i < n; i++)
                for (String s : prev)
                    curr.add(s + (char)(cStart + i));
            prev = curr;
        }
        return curr;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String digits = "23";
        List<String> strs = solution.letterCombinations(digits);
        System.out.println(strs);
    }
}