import java.util.Arrays;
import java.util.Comparator;


public class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        System.out.println("---> twoSum");
        int n = nums.length;
        Integer[] ind = new Integer[n];
        for (int i = 0; i < n; i++)
            ind[i] = i;
        Arrays.sort(ind, new Comparator(){
            public int compare(Object o1, Object o2){
                int k1 = (Integer)o1;
                int k2 = (Integer)o2;
                return nums[k1] - nums[k2];
            }
        });
        for (int num : ind)
            System.out.print("" + num + ", ");

        for (int i = 0; i < n; i++){
            int k1 = i + 1;
            int k2 = n - 1;
            while (k1 <= k2){
                int k = (k1 + k2) / 2;
                int s = nums[ind[i]] + nums[ind[k]];
                if (s == target)
                    return new int[]{ind[i], ind[k]};
                else if (s < target)
                    k1 = k + 1;
                else
                    k2 = k - 1;
            }
        }

        // System.out.println();
        // for (int i = 0; i< n; i++){
        //     for (int j = i + 1; j < n; j++){
        //         if (nums[i] + nums[j] == target)
        //             return new int[]{i, j};
        //     }
        // }
        return null;
    }

    public static void main(String[] args){
        Solution2 sol = new Solution2();
        int[] nums = {3, 2, 1, 4};
        int target = 6;
        int[] result = sol.twoSum(nums, target);
        for(int i = 0; i < result.length; i++)
            System.out.println(result[i]);
    }
}