public class Solution {
    public int minDistance(String word1, String word2) {
        String sh = word1;
        String lo = word2;
        if (word1.length() > word2.length()){
            sh = word2;
            lo = word1;
        }
        int m = sh.length();
        int[] cost = new int[m + 1];
        int prev = 0, curr = 0;
        // int[] cost2 = new int[m + 1];
        for (int i = 0; i <= m; i++)
            cost[i] = i;
        for (int j = 0; j < lo.length(); j++){
            // cost2[0] = j + 1;
            prev = j;
            cost[0] = j + 1;
            for (int i = 0; i < m; i++){
                if (lo.charAt(j) == sh.charAt(i))
                    curr = prev;
                else{
                    int min = prev;
                    if (cost[i + 1] < min)
                        min = cost[i + 1];
                    if (cost[i] < min)
                        min = cost[i];
                    curr = min + 1;
                }
                prev = cost[i + 1];
                cost[i + 1] = curr;
            }
        }
        return cost[m];
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String word1 = "abcd";
        String word2 = "bced";
        System.out.println(solution.minDistance(word1, word2));
    }
}