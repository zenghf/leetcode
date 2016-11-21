public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int n = 1;
        int lastNum = nums[0];
        for(int i = 1; i < nums.length; i++){
            if (nums[i] > lastNum){
                lastNum = nums[i];
                nums[n++] = nums[i];
            }
        }

        return n;
    }
}