import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        Arrays.sort(nums);
        int i = 0;
        while(i < nums.length){
            int count = 1;
            while(i + count < nums.length && nums[i + count] == nums[i])
                count++;
            int size = res.size();
            for (int j = 0; j < size; j++){
                List<Integer> list = new ArrayList<>(res.get(j));
                for (int k = 0; k < count; k++){
                    list.add(nums[i]);
                    res.add(new ArrayList<Integer>(list));
                }
            }
            i += count;
        }
        return res;
    }


    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {1, 2, 2};
        System.out.println(solution.subsetsWithDup(nums));
    }
}