import java.util.*;


public class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> count = new HashMap<>();
        ArrayList<Integer> ind = new ArrayList<Integer>();
        HashMap<Character, Integer> T = new HashMap<>();
        for (char ch : t.toCharArray())
            T.put(ch, T.getOrDefault(ch, 0) + 1);
        // System.out.println(T);

        // HashMap<Character, Integer> S = new HashMap<>();
        // for (char ch : s.toCharArray())
        //     S.put(ch, S.getOrDefault(ch, 0) + 1);
        // System.out.println(S);

        int minStart = -1, minEnd = -1, minLen = Integer.MAX_VALUE, nOK = 0;
        int indStart = 0;
        boolean findFirstWindow = false;

        // System.out.println(T.size());

        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (T.containsKey(ch)){
                ind.add(i);
                count.put(ch, count.getOrDefault(ch, 0) + 1);
                if (!findFirstWindow){
                    if (count.get(ch).equals(T.get(ch)))
                        nOK++;
                    // if (ch == 'a')
                    //     System.out.println("" + count.get(ch) + "   " + T.get(ch) + "   " + nOK);
                    // System.out.println("" + count + "\n\t" + nOK);
                    if (nOK == T.size())
                        findFirstWindow = true;
                }
                if (findFirstWindow){
                    char first = s.charAt(ind.get(indStart));
                    while(count.get(first) > T.get(first)){
                        count.put(first, count.get(first) - 1);
                        indStart++;
                        first = s.charAt(ind.get(indStart));
                    }
                    int len = i + 1 - ind.get(indStart);
                    if (minStart == -1 || len < minLen){
                        minStart = ind.get(indStart);
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
        // String s = in.nextLine();
        // String t = in.nextLine();
        String s = "a";
        String t = "a";
        System.out.println(solution.minWindow(s, t));
    }
}