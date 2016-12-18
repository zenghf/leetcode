public class Solution {
    public void rotate(int[] nums, int k) {

        int len = nums.length;
        while(k < 0)
            k += len;
        k = k % len;
        if (k == 0)
            return;
        int n = nums.length, m = k;
        while(n % m != 0){
            int temp = n % m;
            n = m;
            m = temp;
        }
        for(int i = 0; i < m; i++){
            int temp = nums[i];
            int curr = i;
            int next = (curr - k + len) % len;
            while(next != i){
                nums[curr] = nums[next];
                curr = next;
                next = (curr - k + len) % len;
            }
            nums[curr] = temp;
        }
    }

    private void print(int[] nums){
        System.out.print("[");
        for (int num : nums)
            System.out.print(" " + num);
        System.out.println("]");
    }

    public static void main(String[] args){
        System.out.println((-4) % 3);
        // Solution solution = new Solution();
        // int[] nums = {1, 2, 3, 4};
        // solution.print(nums);
        // solution.rotate(nums, 1);
        // solution.print(nums);
    }
}