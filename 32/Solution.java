public class Solution {
    public int longestValidParentheses(String s) {
        if (s.length() < 2)
            return 0;
        // table of the same length as `s`; 0 corresponds to '('
        // a positive number n means the longest paired '(' is n character left to it
        // -1 means no paired '('
        int[] pairedRelativeIndex = new int[s.length()];
        int maxRelLoc = -1;
        int fromIndex = 0;
        int i = s.indexOf(')', fromIndex);
        while (i >= 0){
            int curr = i - 1;
            int minPairedInd = i + 1;
            boolean foundOpeningParenthesis = false;
            // System.out.println("i = " + i);
            while (curr >= 0){
                // System.out.println("curr = " + curr);
                if (pairedRelativeIndex[curr] == 0){
                    if (foundOpeningParenthesis)
                        break;
                    else{
                        foundOpeningParenthesis = true;
                        minPairedInd = curr;
                    }
                    curr--;
                }
                else if (pairedRelativeIndex[curr] == -1){
                    break;
                }
                else{
                    if (foundOpeningParenthesis){
                        minPairedInd = curr - pairedRelativeIndex[curr];
                        break;
                    }
                    curr = curr - pairedRelativeIndex[curr] - 1;
                }
            }
            int length = i - minPairedInd;
            pairedRelativeIndex[i] = length;
            if (length > maxRelLoc)
                maxRelLoc = length;
            fromIndex = i + 1;
            i = s.indexOf(')', fromIndex);
        }
        // for (i = 0; i < s.length(); i++){
        //     System.out.print(" " + pairedRelativeIndex[i]);
        // }
        System.out.println();
        return maxRelLoc + 1;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String s = "()(())";
        System.out.println(s + " : " + solution.longestValidParentheses(s));
    }
}