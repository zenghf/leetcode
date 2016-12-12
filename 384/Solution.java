import java.util.Random;

public class Solution {

    private int[] inds;
    private int[] nums;
    private int n;

    public Solution(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.inds = new int[this.n];
        for (int i = 0; i < this.n; i++)
            inds[i] = i;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        int[] nums2 = new int[this.n];
        for (int i = 0; i < this.n; i++)
            nums2[this.inds[i]] = this.nums[i];
        for (int i = 0; i < this.n; i++)
            this.inds[i] = i;
        this.nums = nums2;
        return nums2;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random rand = new Random();
        for (int i = this.nums.length; i > 0; i--){
            int j = rand.nextInt(i);
            swap(this.nums, i - 1, j);
            swap(this.inds, i - 1, j);
        }
        return this.nums;
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