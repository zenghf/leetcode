public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length < 2)
            return nums;
        int n = nums.length;
        int[] output = new int[n];
        output[0] = 1;
        for (int i = 1; i < n; i++)
            output[i] = output[i - 1] * nums[i - 1];
        int p = 1;
        for (int i = n - 2; i >= 0; i--){
            p *= nums[i + 1];
            output[i] *= p;
        }
        return output;
    }
}