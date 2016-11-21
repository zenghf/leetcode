public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        int n = 1;
        for(int i = 1; i < nums.length; i++){
            if (nums[i] > nums[n - 1]){
                nums[n++] = nums[i];
            }
        }

        return n;
    }
}