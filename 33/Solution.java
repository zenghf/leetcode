public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int n = nums.length;
        if (n == 1)
            return nums[0] == target ? 0 : -1;
        int low = 0, high = nums.length - 1, mid = 0;
        int p = high;
        if (nums[high] < nums[low]){
            while (high > low + 1){
                mid = (low + high) / 2;
                if (nums[mid] > nums[low])
                    low = mid;
                else
                    high = mid;
            }
            p = low;
        }
        System.out.println("p: " + p);
        if (target > nums[p] || target < nums[(p + 1) % n])
            return -1;
        if (target == nums[0])
            return 0;
        if (target < nums[0]){
            low = p + 1;
            high = n - 1;
        }
        else{
            low = 1;
            high = p;
        }
        while (high >= low){
            mid = (high + low) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {1, 3};
        int target = 3;
        solution.search(nums, target);
    }
}