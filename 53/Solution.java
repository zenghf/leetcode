public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length < 1)
            return 0;
        int maxSum = Integer.MIN_VALUE;
        int cumSum = 0;
        for (int num : nums){
            cumSum += num;
            if (cumSum > maxSum)
                maxSum = cumSum;
            if (cumSum < 0)
                cumSum = 0;
        }
        return maxSum;
    }
}