public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;
        int maxArea = 0;
        int n = heights.length;
        int[] left = new int[n];
        for(int i = 0; i < n; i++)
            left[i] = i;
        for(int i = 1; i < n; i++){
            int ind = i;
            int curr = heights[i];
            while(ind > 0 && heights[ind - 1] >= curr)
                ind = left[ind - 1];
            left[i] = ind;
        }

        int[] right = new int[n];
        for(int i = 0; i < n; i++)
            right[i] = i;
        for(int i = n - 2; i >= 0; i--){
            int ind = i;
            int curr = heights[i];
            while(ind < n - 1 && heights[ind + 1] >= curr)
                ind = right[ind + 1];
            right[i] = ind;
        }

        for(int i = 0; i < n; i++){
            int area = heights[i] * (right[i] - left[i] + 1);
            if (area > maxArea)
                maxArea = area;
        }

        print(heights);
        print(left);
        print(right);
        System.out.println(maxArea);
        return maxArea;
    }

    private void print(int[] heights){
        System.out.print("[");
        for (int num : heights)
            System.out.print(" " + num);
        System.out.println("]");
    }

    public static void main(String[] args){
        int[] heights = {4,2,0,3,2,4,3,4};
        Solution solution = new Solution();
        solution.largestRectangleArea(heights);
    }
}