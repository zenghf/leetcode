import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (candidates.length < 1)
            return result;
        Arrays.sort(candidates);
        ArrayList<Integer> cand = new ArrayList<>();
        if (candidates[0] > 0)
            cand.add(candidates[0]);
        int i = 1;
        for (; i < candidates.length && candidates[i] <= target; i++)
            if (candidates[i] > 0 && candidates[i] > candidates[i - 1])
                cand.add(candidates[i]);
        // System.out.println("cand: i " + i + candidates[i]);
        // boolean hasTarget = false;
        // if (i < candidates.length && candidates[i] == target)
        //     hasTarget = true;
        // System.out.println("hasTarget: " + hasTarget);
        if (cand.isEmpty())
            return result;
        int n = cand.size();
        int min = cand.get(0);
        int max = cand.get(n - 1);
        int sum = 0;
        ArrayList<Integer> comb = new ArrayList<>();
        int nextInd = 0;
        while(true){
            int nextSum = sum + cand.get(nextInd);
            if (nextSum < target){
                comb.add(cand.get(nextInd));
                sum += cand.get(nextInd);
                continue;
            }
            if (nextSum == target){
                ArrayList<Integer> tmp = new ArrayList<>(comb);
                tmp.add(cand.get(nextInd));
                result.add(tmp);
            }

            while(!comb.isEmpty() && comb.get(comb.size() - 1) == max){
                comb.remove(comb.size() - 1);
                sum -= max;
            }

            if (comb.isEmpty())
                break;
            int num = comb.remove(comb.size() - 1);
            sum -= num;
            nextInd = cand.indexOf(num) + 1;

        }

        // if (hasTarget){
        //     ArrayList<Integer> tar = new ArrayList<>();
        //     tar.add(target);
        //     result.add(tar);
        // }
        return result;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        List<List<Integer>> res = solution.combinationSum(new int[]{2, 1}, 4);
        System.out.println(res);
    }
}