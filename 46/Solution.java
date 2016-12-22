import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length == 0)
            return res;
        res.add(new ArrayList<Integer>());
        for (int num : nums){
            int size = res.size();
            for(int i = 0; i < size; i++){
                List<Integer> perm = res.pollFirst();
                for (int j = perm.size(); j >= 0; j--){
                    List<Integer> temp = new ArrayList<Integer>(perm);
                    temp.add(j, num);
                    res.add(temp);
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4};
        List<List<Integer>> res = solution.permute(nums);
        for(List<Integer> list : res)
            System.out.println(list);
    }
}