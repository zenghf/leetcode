import java.util.ArrayList;

public class Solution {
    static private ArrayList<Integer> phb = new ArrayList<>();
    static {
        phb.add(1);
        phb.add(1);
        phb.add(2);
    }
    public int numDecodings(String s) {
        if (s.equals("") || s.equals("0"))
            return 0;
        
        ArrayList<Integer> groups = new ArrayList<>();
        int n = 0;
        char prev = '0';
        char curr = s.charAt(0);
        int prevN = 10, currN = 0;
        for (int i = 0; i < s.length(); i++){
            char next = i < s.length() - 1 ? s.charAt(i + 1) : '9';
            System.out.println("i: " + i);
            System.out.println("prev: " + prev + " curr: " + curr + " next: " + next);
            if (next == '0')
                currN = (curr - '0') * 10;
            else if (curr == '0')
                currN = (prev - '0') * 10;
            else
                currN = curr - '0';
            if (currN < 1 || currN > 26)
                return 0;
            if (currN < 10 && prevN * 10 + currN <= 26)
                n++;
            else {
                groups.add(n);
                n = 1;
            }
            System.out.println("prevN: " + prevN + " currN: " + currN);
            prevN = currN;
            prev = curr;
            curr = next;
            System.out.println(groups);
        }
        groups.add(n);
        System.out.println(groups);
        int res = 1;
        for (int ncomb : groups)
            res *= comb(ncomb);
        return res;
    }
    
    private int comb(int n){
        if (n < phb.size())
            return phb.get(n);
        int res = comb(n - 2) + comb(n - 1);
        if (phb.size() == n)
            phb.add(res);
        return res;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String s = "110";
        System.out.println(solution.numDecodings(s));
    }
}