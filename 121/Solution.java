public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        int min = prices[0], maxProfit = 0;
        for (int i = 1; i < prices.length; i++){
            int p = prices[i];
            if (p < min)
                min = p;
            if (p - min > maxProfit)
                maxProfit = p - min;
        }
        return maxProfit;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}