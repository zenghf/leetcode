import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<Character> symbols = new ArrayList<>();
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
        return compute(nums, symbols);
        // return result;
    }

    private ArrayList<Integer> compute(List<Integer> nums, List<Character> symbols){
        ArrayList<Integer> result = new ArrayList<>();
        if (symbols.size() == 0){
            result.add(nums.get(0));
            return result;
        }
        for (int i = 0; i < symbols.size(); i++){
            ArrayList<Integer> list1 = compute(nums.subList(0, i+1), symbols.subList(0, i));
            ArrayList<Integer> list2 = compute(nums.subList(i+1, nums.size()), symbols.subList(i + 1, symbols.size()));
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