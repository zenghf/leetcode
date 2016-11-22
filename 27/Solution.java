public class Solution {
    public int removeElement(int[] nums, int val) {
        int n = 0;
        for (int num : nums){
            if (num != val)
                nums[n++] = num;
        }
        return n;
    }
}