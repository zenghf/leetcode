public class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int negFront = 1, negEnd = 1, prod = 1, maxProd = 0, prev = 0, negFirst = -1, negLast = -1, n = 0;
        boolean findsFirstNegative = false, isFirstNumberNegative = false;
        for (int i = 0; i <= nums.length; i++){
            int num = i < nums.length ? nums[i] : 0;
            if (prev == 0){
                negFront = 1;
                negEnd = 1;
                prod = 1;
                n = 0;
                findsFirstNegative = false;
                isFirstNumberNegative = num < 0;
            }
            if (num == 0 && n >= 1){
                if (prod > 0){
                    if (prod > maxProd)
                        maxProd = prod;
                }
                else if (n >= 2){
                    System.out.println("n: " + n + " prod: " + prod);
                    if (prod / negFront > maxProd)
                        maxProd = prod / negFront;
                    if (prod / negEnd > maxProd)
                        maxProd = prod / negEnd;
                    if (!isFirstNumberNegative && negFront / negFirst > maxProd)
                        maxProd = negFront / negFirst;
                    if (prev > 0 && negEnd / negLast > maxProd)
                        maxProd = negEnd / negLast;
                }
            }
            if (num < 0){
                if (!findsFirstNegative){
                    negFront *= num;
                    findsFirstNegative = true;
                    negFirst = num;
                }
                negLast = num;
                negEnd = 1;
            }
            if (!findsFirstNegative)
                negFront *= num;
            negEnd *= num;
            prod *= num;
            n++;
            prev = num;
        }
        return maxProd;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.maxProduct(new int[]{0, -2, 0}));
    }
}