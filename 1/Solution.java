public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i< n; i++){
            for (int j = i + 1; j < n; j++){
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        return null;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] result = sol.twoSum(nums, target);
        for(int i = 0; i < result.length; i++)
            System.out.println(result[i]);
    }
}