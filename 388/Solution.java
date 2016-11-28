import java.util.ArrayList;

public class Solution {
    public int lengthLongestPath(String input) {
        ArrayList<Integer> prefixLength = new ArrayList<>();
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
            if (nTab == 0)
                currLength = word.length();
            else
                currLength = word.length() - nTab + prefixLength.get(nTab - 1);
            if (word.indexOf('.') != -1 && currLength > maxLength)
                maxLength = currLength;
            while(prefixLength.size() <= nTab )
                prefixLength.add(0);
            prefixLength.set(nTab, currLength + 1);
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