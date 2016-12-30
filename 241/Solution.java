import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Solution {
    private HashMap<Integer, HashMap<Integer, ArrayList<Integer>>> cache;
    ArrayList<Integer> nums;
    ArrayList<Character> symbols;

    public List<Integer> diffWaysToCompute(String input) {
        nums = new ArrayList<>();
        symbols = new ArrayList<>();
        cache = new HashMap<>();
        int start = 0;
        for (int i = 0; i < input.length(); i++){
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*'){
                nums.add(Integer.parseInt(input.substring(start, i)));
                start = i + 1;
                symbols.add(input.charAt(i));
            }
        }
        // System.out.println("" + start + "[" + input.substring(start, input.length()) + "]");
        nums.add(Integer.parseInt(input.substring(start, input.length())));
        int n = symbols.size();
        return compute(0, n);
        // return result;
    }

    private ArrayList<Integer> compute(int n1, int n2){
        if (cache.get(n1) == null)
            cache.put(n1, new HashMap<Integer, ArrayList<Integer>>());
        HashMap<Integer, ArrayList<Integer>> cacheN1 = cache.get(n1);
        if (cacheN1.get(n2) != null)
            return cacheN1.get(n2);
        ArrayList<Integer> result = new ArrayList<>();
        cacheN1.put(n2, result);

        if (n1 == n2){
            result.add(nums.get(n1));
            return result;
        }
        for (int i = n1; i < n2; i++){
            ArrayList<Integer> list1 = compute(n1, i);
            ArrayList<Integer> list2 = compute(i + 1, n2);
            char sym = symbols.get(i);
            for (int a : list1){
                for (int b : list2){
                    if (sym == '+')
                        result.add(a + b);
                    else if (sym == '-')
                        result.add(a - b);
                    else
                        result.add(a * b);
                }
            }

        }
        return result;
    }
}