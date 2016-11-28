import java.util.ArrayList;

public class Solution {
    private static ArrayList<Integer> steps;
    static{
        steps = new ArrayList<>();
        steps.add(1);
        steps.add(2);
    }
    public int climbStairs(int n) {
        for (int i = steps.size(); i < n; i++)
            steps.add(steps.get(i - 1) + steps.get(i - 2));
        return steps.get(n - 1);
    }
}