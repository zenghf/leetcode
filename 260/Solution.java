public class Solution {
    public int[] singleNumber(int[] nums) {
        int d = 0;
        for (int num : nums)
            d ^= num;
        int b = 1;
        while(d != 1){
            d = (d >>> 1);
            b = (b << 1);
        }
        int[] res = {0, 0};
        for (int num : nums){
            if ((num & b) == 0)
                res[0] ^= num;
            else
                res[1] ^= num;
        }
        return res;
    }
}