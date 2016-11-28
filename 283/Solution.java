public class Solution {
    public void moveZeroes(int[] nums) {
        int indNonZero = 0;
        int indCurr = 0;
        for (int num : nums){
            if (num != 0){
                if (indNonZero != indCurr)
                    nums[indNonZero] = nums[indCurr];
                indNonZero++;
            }
            indCurr++;
        }
        for (int i = indNonZero; i < nums.length; i++)
            nums[i] = 0;
    }
}