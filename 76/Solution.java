import java.util.*;


public class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, LinkedList<Integer>> dicInd = new HashMap<>();
        ArrayList<Integer> ind = new ArrayList<Integer>();
        HashMap<Character, Integer> count = new HashMap<>();
        for (char ch : t.toCharArray())
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        int minStart = -1, minEnd = -1, minLen = Integer.MAX_VALUE, nOK = 0;
        int indStart = 0;
        boolean findFirstWindow = false;
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (count.containsKey(ch)){
                if (!dicInd.containsKey(ch))
                    dicInd.put(ch, new LinkedList<Integer>());
                dicInd.get(ch).add(i);
                if (dicInd.get(ch).size() == count.get(ch))
                    nOK++;
                if (!findFirstWindow && nOK == count.size())
                    findFirstWindow = true;
                ind.add(i);
                if (findFirstWindow){
                    char first = s.charAt(ind.get(indStart));
                    while(dicInd.get(first).size() > count.get(first)){
                        dicInd.get(first).pollFirst();
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
        System.out.println(dicInd);
        System.out.println(ind);

        return s.substring(minStart, minEnd + 1);
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.minWindow("acbbaca", "aba"));
    }
}