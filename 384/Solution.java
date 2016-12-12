import java.util.Random;

public class Solution {

    private int[] nums;
    private int n;

    public Solution(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random rand = new Random();
        int[] nums2 = this.nums.clone();
        for (int i = this.nums.length; i > 0; i--){
            int j = rand.nextInt(i);
            swap(nums2, i - 1, j);
        }
        return nums2;
    }

    private void swap(int[] nums, int i, int j){
        if (i == j)
            return;
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public void print(int[] nums){
        System.out.print("[");
        for (int num : nums)
            System.out.print("" + num + " ");
        System.out.println("]");
    }

    public static void main(String[] args){
        int[] nums = {3, 5, 7, 2, 1, 6};
        Solution solution = new Solution(nums);
        solution.print(nums);
        solution.print(solution.shuffle());
        solution.print(solution.reset());
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */