// import java.util.LinkedList;
// import java.util.List;
import java.util.*;

public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        if (buildings == null || buildings.length == 0)
            return res;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });

        PriorityQueue<Integer> heights = new PriorityQueue<>();
        for (int[] b : buildings){
            pq.add(new int[]{b[0], b[2]});
            pq.add(new int[]{b[1], -b[2]});
        }
        int ind = pq.peek()[0];
        int prevHeight = 0;
        while (!pq.isEmpty()){
            int[] b = pq.poll();
            if (b[0] != ind){
                int h = heights.isEmpty() ? 0 : -heights.peek();
                if (h != prevHeight){
                    res.add(new int[]{ind, h});
                    prevHeight = h;
                }
            }
            if (b[1] < 0)
                heights.remove(b[1]);
            else
                heights.add(-b[1]);
            ind = b[0];
        }
        res.add(new int[]{ind, 0});
        return res;
    }

    public static void main(String[] args){
        int[][] buildings = new int[][]{ {2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8} };
        Solution solution = new Solution();
        List<int[]> list = solution.getSkyline(buildings);
        for (int[] step : list){
            System.out.print("[");
            for (int num : step)
                System.out.print(" " + num);
            System.out.println("]");
        }
    }
}