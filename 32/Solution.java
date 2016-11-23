public class Solution {
    public int longestValidParentheses(String s) {
        if (s.length() < 2)
            return 0;
        int[] dic = new int[s.length()];
        int maxLength = -1;
        int fromIndex = 0;
        int i = s.indexOf(')', fromIndex);
        while (i >= 0){
            int nPair = 1;
            int curr = i;
            int lowestValid = i + 1;
            boolean canFindPair = true;
            while (curr > 0){
                curr--;
                if (dic[curr] == 0){
                    nPair--;
                    if (nPair == 0)
                        lowestValid = curr;
                    else if (nPair < 0)
                        break;
                }
                else if (dic[curr] == -1){
                    break;
                }
                else{
                    nPair++;
                    curr = curr - dic[curr] + 1;
                }
            }
            int length = i - lowestValid;
            dic[i] = length;
            if (length > maxLength)
                maxLength = length;
            fromIndex = i + 1;
            i = s.indexOf(')', fromIndex);
        }
        for (i = 0; i < s.length(); i++){
            System.out.print(" " + dic[i]);
        }
        System.out.println();
        return maxLength + 1;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String s = ")()())()()(";
        System.out.println(s + " : " + solution.longestValidParentheses(s));
    }
}