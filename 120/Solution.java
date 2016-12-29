public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        List<Integer> total = triangle.get(height - 1);
        for (int h = height - 2; h >= 0; h--){
            List<Integer> t = new ArrayList<Integer>();
            for (int i = 0; i <= h; i++)
                t.add(Math.min(total.get(i), total.get(i + 1)) + triangle.get(h).get(i));
            total = t;
        }
        return total.get(0);
    }
}