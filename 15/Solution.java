import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
            list.add(nums[i]);
        Collections.sort(list);
        List<List<Integer>> res = new ArrayList<>();
        int n = list.size();
        int k1 = 0, k2 = 1, k3 = 2, klow = 2, kup = n - 1;
        Integer prev = 1;
        Integer prevn1 = 1;
        Integer prevn2 = 1;
        for (; k1 < n - 2; k1++){
            Integer n1 = list.get(k1);
            // System.out.println("--: " + k1 + " : " + n1);
            if (n1 == prev && n1 != 0)
                continue;
            // System.out.println("before k2");
            for (k2 = k1 + 1; k2 < n - 1 && list.get(k2) * 2 + n1 <= 0; k2++){
                Integer n2 = list.get(k2);
                // System.out.println("----: " + n2);
                if (n1 == prevn1 && n2 == prevn2)
                    continue;
                if(list.get(n - 1) + n1 + n2 < 0)
                    continue;
                if(list.get(k2 + 1) + n1 + n2 > 0)
                    continue;
                klow = k2 + 1;
                kup = n - 1;
                while(klow <= kup){
                    k3 = (klow + kup) / 2;
                    Integer n3 = list.get(k3);
                    // System.out.println("------: " + n3);
                    int s = n1 + n2 + n3;
                    if (s == 0){
                        res.add(Arrays.asList(new Integer[]{n1, n2, n3}));
                        prevn1 = n1;
                        prevn2 = n2;
                        break;
                    }
                    else if(s < 0){
                        klow = k3 + 1;
                    }
                    else{
                        kup = k3 - 1;
                    }
                }
            }
            prev = n1;
        }
        return res;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        List<List<Integer>> res = solution.threeSum(new int[]{0, 0, 0, 0});
        for (List<Integer> list : res)
            System.out.println(list);
    }
}