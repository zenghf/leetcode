public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int tc = 1;
        int nn = n, kk = 1;
        for (int i = 0; i < k; i++){
            tc *= nn--;
            tc /= kk++;
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Integer[] ord = new Integer[k];
        for (int i = 0; i < k; i++)
            ord[i] = i + 1;
        ord[k - 1] = k - 1;
        for (int i = 0; i < tc; i++){
            if (ord[k - 1] != n){
                ord[k - 1]++;
            }
            else{
                int j = k - 1, val = n;
                while(ord[j] == val){
                    // System.out.println("j: " + j + " n:" + n);
                    j--;
                    val--;
                }
                ord[j]++;
                j++;
                for (; j < k; j++)
                    ord[j] = ord[j - 1] + 1;
            }
            // System.out.println(Arrays.asList(ord));
            res.add(new ArrayList<Integer>(Arrays.asList(ord)));
        }
        return res;
    }
}