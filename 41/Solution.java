import java.util.ArrayList;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int indJunk = n - 1;
        // boolean swapSmallerNumber = false;
        for (int j = 0; j < 1; j++){
            for (int i = 0; i <= indJunk; i++){
                int num = nums[i];
                while (num - 1 < i && num > 0 && nums[i] != nums[num -1]){
                    swap(nums, num - 1, i);
                    num = nums[i];
                    print(i, nums);

                }
            }
        }
        for (int i = 0; i < n; i++){
            if (nums[i] != i + 1)
                return i + 1;
        }
        return n + 1;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void print(int i, int[] nums){
        System.out.print("" + (i + 1) + ":");
        for (int temp : nums)
            System.out.print(" " + temp);
        System.out.println();
    }


    public static void main(String[] args){
        Solution solution = new Solution();
        // int[] nums = {-3,9,16,4,5,16,-4,9,26,2,1,19,-1,25,7,22,2,-7,14,2,5,-6,1,17,3,24,-4,17,15};
        // int[] nums = {11,1,6,11,5,5,-6,9,-3,9,5,4,2,-8,16,-6,-4,2,3};
        int[] nums = {2, 1, 1};
        System.out.println(solution.firstMissingPositive(nums));
    }
}