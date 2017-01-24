import java.util.ArrayList;

public class Solution {
    public String getPermutation(int n, int k) {
        if (n == 1)
            return "1";
        int N = n;
        int[] fac = new int[n - 1];
        fac[0] = 1;
        for (int i = 1; i < n - 1; i++)
            fac[i] = fac[i - 1] * (i + 1);
        int K = k - 1;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(i + 1);
        StringBuilder sb = new StringBuilder();
        for(; N > 1; N--){
            int ind = K / fac[N - 2];
            sb.append(list.get(ind));
            list.remove(ind);
            K = K - ind * fac[N - 2];
        }
        sb.append(list.get(0));
        return sb.toString();
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.getPermutation(3, 6));
    }
}