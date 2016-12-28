public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1 || nums[0] > nums[1])
            return 0;
        int low = 0, high = nums.length - 1;
        while (high > low + 1){
            int mid = (high + low) / 2;
            if (nums[mid + 1] > nums[mid])
                low = mid;
            else
                high = mid;
        }
        return high;
    }
}