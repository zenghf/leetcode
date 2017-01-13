import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }
    public void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums, int start){
        System.out.println("list:" + list + " start: " + start);
        res.add(new ArrayList<Integer>(list));
        for (int i = start; i < nums.length; i++){
            if (i > start && nums[i] == nums[i - 1])
                continue;
            list.add(nums[i]);
            backtrack(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {1, 2, 2};
        solution.subsetsWithDup(nums);
    }
}