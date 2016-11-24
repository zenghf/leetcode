public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (target < nums[0] || target > nums[nums.length - 1])
            return new int[]{-1, -1};
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int mid = 0;
        while(low <= high){
            mid = (low + high) / 2;
            if (nums[mid] == target)
                break;
            if (nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        if (nums[mid] != target){
            return new int[]{-1, -1};
        }

        int ind = mid;
        int n1 = 0;
        int n2 = n - 1;
        if (ind > 0){
            low = 0;
            high = ind;
            while(low <= high){
                mid = (low + high) / 2;
                // System.out.println("low, mid, high = " + low + " " + mid + " " + high);
                if (nums[mid] == target)
                    high = mid - 1;
                else if (nums[mid + 1] == target){
                    n1 = mid + 1;
                    break;
                }
                else
                    low = mid + 1;
            }
        }

        if (ind < n - 1){
            low = ind;
            high = n - 1;
            while (low <= high){
                mid = (low + high) / 2;
                if (nums[mid] == target)
                    low = mid + 1;
                else if (nums[mid - 1] == target){
                    n2 = mid - 1;
                    break;
                }
                else
                    high = mid - 1;
            }
        }

        return new int[]{n1, n2};
    }


    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {1, 4};
        int target = 4;
        int[] result = solution.searchRange(nums, target);
        System.out.println("" + result[0] + " " + result[1]);
    }
}