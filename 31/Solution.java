public class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n <= 1)
            return;
        int k = n - 1;
        while(k > 0 && nums[k - 1] >= nums[k]){
            k--;
        }
        System.out.println(k);

        if (k > 0){
            int num = nums[k - 1];
            int j = k;
            while (j < n && nums[j] > num)
                j++;
            j--;
            int tmp = nums[j];
            nums[j] = nums[k - 1];
            nums[k - 1] = tmp;
        }

        for (int front = k, end = n - 1; front < end; front++, end--){
            int tmp = nums[front];
            nums[front] = nums[end];
            nums[end] = tmp;
        }


    }

    private void print(int[] nums){
        for (int i = 0; i < nums.length; i++)
            System.out.print("" + nums[i] + " ");
        System.out.println();
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {5, 1, 1};
        for (int i = 0; i < 3; i++){
            solution.print(nums);
            solution.nextPermutation(nums);
        }
    }

}