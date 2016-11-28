public class Solution {
    public int rob(int[] nums) {
        int v0 = 0, v1 = 0, v2 = 0;
        for (int i = 0; i < nums.length; i++){
            v2 = v0 + nums[i] > v1 ? v0 + nums[i] : v1;
            v0 = v1;
            v1 = v2;
        }
        return v2;
    }
}