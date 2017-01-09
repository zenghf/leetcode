import java.util.*;


public class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, LinkedList<Integer>> dicInd = new HashMap<>();
        ArrayList<Integer> ind = new ArrayList<Integer>();
        HashMap<Character, Integer> count = new HashMap<>();
        for (char ch : t.toCharArray())
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        int start = -1, end = -1, nOK = 0;
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (count.containsKey(ch)){
                if (dicInd.isEmpty())
                    start = i;
                if (!dicInd.containsKey(ch))
                    dicInd.put(ch, new LinkedList<Integer>());
                dicInd.get(ch).add(i);
                if (dicInd.get(ch).size() == count.get(ch))
                    nOK++;
                if (end == -1 && nOK == count.size())
                    end = i;
                ind.add(i);
            }
        }
        System.out.println(dicInd);
        System.out.println(ind);
        if (start == -1 || end == -1)
            return "";
        int minLen = end - start + 1, minStart = start, minEnd = end;
        System.out.println("minLen: " + minLen + " start: " + start + " end: " + end);
        for(int indStart = 1; indStart < ind.size(); indStart++){
            char ch = s.charAt(ind.get(indStart - 1));
            LinkedList<Integer> list = dicInd.get(ch);
            list.pollFirst();
            if (list.size() < count.get(ch))
                break;
            start = ind.get(indStart);
            end = Math.max(end, list.get(count.get(ch) - 1));
            if (end + 1 - start < minLen){
                minStart = start;
                minEnd = end;
                minLen = end + 1 - start;
            }
        }
        return s.substring(minStart, minEnd + 1);
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.minWindow("acbbaca", "aba"));
    }
}