import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final int BASE = 4;
    private static final char[] dic = {'A', 'C', 'G', 'T'};
    private static final int C = (int) Math.pow(BASE, 9);
    private static final HashMap<Character, Integer> TABLE = new HashMap<>();
    private static final HashMap<Character, Integer> T = new HashMap<>();
    static{TABLE.put('A', 0); TABLE.put('C', 1); TABLE.put('G', 2); TABLE.put('T', 3);
        for (Character ch : TABLE.keySet())
            T.put(ch, TABLE.get(ch) * C);
    }

    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() <= 10)
            return new ArrayList<String>();
        HashSet<Integer> repeated = new HashSet<>();
        HashSet<Integer> hash = new HashSet<>();
        int h = 0;
        for (int i = 9; i >= 0; i--){
            h <<= 2;
            h += TABLE.get(s.charAt(i));
        }
        hash.add(h);
        for (int i = 10; i < s.length(); i++){
            h >>= 2;
            h += T.get(s.charAt(i));
            if (!hash.add(h))
                repeated.add(h);
        }
        ArrayList<String> res = new ArrayList<>();
        for (Integer H : repeated){
            StringBuilder sb = new StringBuilder(10);
            for (int i = 0; i < 10; i++){
                // System.out.println(dic[H & 3]);
                sb.append(dic[H & 3]);
                H >>>= 2;
            }
            res.add(sb.toString());
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args){
        String str = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        Solution solution = new Solution();
        solution.findRepeatedDnaSequences(str);
    }
}