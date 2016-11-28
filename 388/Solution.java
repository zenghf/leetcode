import java.util.Stack;

public class Solution {
    public int lengthLongestPath(String input) {
        Stack<Integer> prefixLength = new Stack<>();
        prefixLength.push(0);
        int maxLength = 0;
        String[] words = input.split("\n");
        for (String word: words){
            int nTab = 0;
            while(nTab < word.length() && word.charAt(nTab) == '\t')
                nTab++;
            int currLength = 0;
            // System.out.println(word + nTab);
            // prefixLength.set(0, 100);
            // System.out.println("word + nTab");
            while(prefixLength.size() > nTab + 1)
                prefixLength.pop();
            currLength = word.length() - nTab + prefixLength.peek();
            if (word.contains(".") && currLength > maxLength)
                maxLength = currLength;
            else
                prefixLength.push(currLength + 1);
            // System.out.println(prefixLength);
        }
        return maxLength;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String s = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        System.out.println(solution.lengthLongestPath(s));
    }
}