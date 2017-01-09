import java.util.*;


public class Solution {
    public String minWindow(String s, String t) {
        int[] count = new int[128];
        int[] T = new int[128];
        for (char ch : t.toCharArray())
            T[ch]++;
        int nUnique = 0;
        for (int i = 0; i < 128; i++){
            if (T[i] > 0)
                nUnique++;
        }

        int minStart = -1, minEnd = -1, minLen = Integer.MAX_VALUE, nOK = 0;
        int start = 0;
        boolean findFirstWindow = false;

        // System.out.println(T.size());

        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (T[ch] > 0){
                count[ch]++;
                if (!findFirstWindow){
                    if (count[ch] == T[ch])
                        nOK++;
                    // if (ch == 'a')
                    //     System.out.println("" + count.get(ch) + "   " + T.get(ch) + "   " + nOK);
                    // System.out.println("" + count + "\n\t" + nOK);
                    if (nOK == nUnique)
                        findFirstWindow = true;
                }
                if (findFirstWindow){
                    char letter = s.charAt(start);
                    // System.out.println("i :" + i + " start: " + start + " letter: " + letter + "  " + T + "  " + count);
                    while(true){
                        if (T[letter] > 0){
                            if (count[letter] > T[letter])
                                count[letter]--;
                            else
                                break;
                        }
                        start++;
                        letter = s.charAt(start);
                        // System.out.println("" + start + " " + letter);
                    }
                    int len = i + 1 - start;
                    if (minStart == -1 || len < minLen){
                        minStart = start;
                        minEnd = i;
                        minLen = len;
                    }
                }
            }
        }
        if (!findFirstWindow)
            return "";
        // System.out.println(dicInd);
        // System.out.println(ind);

        return s.substring(minStart, minEnd + 1);
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String t = in.nextLine();
        // String s = "a";
        // String t = "a";
        System.out.println(solution.minWindow(s, t));
    }
}