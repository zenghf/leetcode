import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Integer[] ord = new Integer[k];
        for (int i = 0; i < k; i++)
            ord[i] = i + 1;
        while (true){
            res.add(new ArrayList<Integer>(Arrays.asList(ord)));
            int j = k - 1, val = n;
            while(j >= 0 && ord[j] == val){
                j--;
                val--;
            }
            if (j < 0)
                break;
            ord[j]++;
            j++;
            for (; j < k; j++)
                ord[j] = ord[j - 1] + 1;
        }
        return res;
    }
}