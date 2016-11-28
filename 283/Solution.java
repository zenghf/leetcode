public class Solution {
    public void moveZeroes(int[] nums) {
        int nZeros = 0;
        for (int i = 0; i < nums.length; i++){
            int num = nums[i];
            if (num == 0)
                nZeros++;
            else if (nZeros > 0) {
                nums[i - nZeros] = nums[i];
            }
        }
        for (int i = nums.length - nZeros; i < nums.length; i++)
            nums[i] = 0;
    }
}