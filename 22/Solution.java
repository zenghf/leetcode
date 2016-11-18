import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        if (n <= 0)
            return result;
        char[] str = new char[n * 2];
        dfs(result, str, 0, 0, n);
        return result;
    }

    private void dfs(ArrayList<String> result, char[] str, int nLeft, int nRight, int nParenthesis){
        int pos = nLeft + nRight;
        if (pos == nParenthesis * 2){
            result.add(new String(str));
            return;
        }
        if (nLeft < nParenthesis){
            str[pos] = '(';
            dfs(result, str, nLeft + 1, nRight, nParenthesis);
        }
        if(nRight < nLeft){
            str[pos] = ')';
            dfs(result, str, nLeft, nRight + 1, nParenthesis);
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(3));
    }
}