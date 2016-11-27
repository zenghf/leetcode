public class Solution {
    public int singleNumber(int[] nums) {
        int n = nums[0];
        for (int num : nums)
            n = n ^ num;
        return n;
    }
}