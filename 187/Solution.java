public class Solution {
    private static final int BASE = 4;
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
        HashSet<String> res = new HashSet<>();
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
                res.add(s.substring(i - 9, i + 1));
        }
        return new ArrayList<String>(res);
    }
}