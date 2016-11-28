public class Solution {
    public int rob(int[] nums) {
        return rob(nums, 0, nums.length);
    }

    private int rob(int[] nums, int start, int end){
        if (start >= end)
            return 0;
        if (end - start == 1)
            return nums[start];
        if (end - start == 2)
            return nums[start] > nums[start + 1] ? nums[start] : nums[start + 1];
        int mid = (start + end) / 2;
        int rob0 = nums[mid] + rob(nums, start, mid - 1) + rob(nums, mid + 2, end);
        int rob1 = rob(nums, start, mid) + rob(nums, mid + 1, end);
        return rob0 > rob1 ? rob0 : rob1;
    }
}