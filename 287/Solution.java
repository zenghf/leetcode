
public class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length - 1;
        int low = 1, high = n;
        while (low < high){
            int mid = (low + high) / 2;
            System.out.println("low: " + low + " high: " + high + " mid:" + mid);
            int less = 0, equal = 0, more = 0;
            for (int num : nums){
                if (num > high)
                    continue;
                if (num > mid)
                    more++;
                else if (num == mid)
                    equal++;
                else if (num >= low)
                    less++;
            }
            System.out.println("less: " + less + " more: " + more + " equal: " + equal);
            if (equal > 1)
                return mid;
            if (more > high - mid)
                low = mid + 1;
            else if (less > mid - low)
                high = mid - 1;
            System.out.println("--low: " + low + " high: " + high);
        }
        return low;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {8,1,1,1,2,7,4,3,1,1};
        solution.findDuplicate(nums);
    }
}