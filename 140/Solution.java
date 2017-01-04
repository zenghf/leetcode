public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        ArrayList<String> res = new ArrayList<>();
        HashMap<Integer, Set<String>> dic = new HashMap<>();
        for (String word : wordDict){
            int len = word.length();
            if (!dic.containsKey(len))
                dic.put(len, new HashSet<String>());
            dic.get(len).add(word);
        }
        HashMap<Integer, Set<Integer>> t = new HashMap<>();
        int n = s.length();
        t.put(n, null);
        for (int k = s.length(); k > 0; k--){
            if (!t.containsKey(k))
                continue;
            for (int len : dic.keySet()){
                if (k >= len && dic.get(len).contains(s.substring(k - len, k))){
                    if (!t.containsKey(k - len))
                        t.put(k - len, new HashSet<Integer>());
                    t.get(k - len).add(len);
                }
            }
        }
        assembleSentence(s, t, 0, n, "", res);
        return res;
    }

    private void assembleSentence(String s, HashMap<Integer, Set<Integer>> t, int curr, int n, String str, ArrayList<String> res){
        if (curr == n){
            res.add(str);
            return;
        }
        if (!t.containsKey(curr))
            return;
        if (str.length() > 0)
            str = str + " ";
        for (int len : t.get(curr)){
            assembleSentence(s, t, curr + len, n, str + s.substring(curr, curr + len), res);
        }
    }
}