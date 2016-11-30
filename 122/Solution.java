public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;
        int profit = 0;
        int buy = prices[0];
        int prev = prices[0];
        for (int i = 1; i < prices.length; i++){
            int curr = prices[i];
            if (curr < prev){
                if (prev > buy){
                    profit += prev - buy;
                }
                buy = curr;
            }
            prev = curr;
        }
        if (prev > buy)
            profit += prev - buy;
        return profit;
    }
}