public class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        if (n < 2)
            return 0;
        int prev_left = 0, prev_right = n - 1;
        int left = 0, right = n - 1;
        int maxArea = (n - 1) * (height[0] < height[n - 1] ? height[0] : height[n - 1]);
        while(true){
            System.out.println("left: " + height[left] + " right: " + height[right]);
            boolean left_small = height[left] < height[right];
            if (left_small){
                for (int l = left; l < right; l++){
                    // System.out.println("<" + height[l] + " maxArea: " + maxArea + " left: " + height[left]);
                    int area = (height[l] < height[right] ? height[l] : height[right]) * (right - l);
                    if (area >= maxArea){
                        left = l;
                        maxArea = area;
                    }
                    if (height[l] >= height[right]){
                        left = l;
                        break;
                    }
                    // System.out.println("--<" + height[l] + " maxArea: " + maxArea + " left: " + height[left]);
                }
            }
            else{
                for (int r = right; r > left; r--){
                    int area = (height[left] < height[r] ? height[left] : height[r]) * (r - left);
                    if (area >= maxArea){
                        right = r;
                        maxArea = area;
                    }
                    if (height[r] > height[left]){
                        right = r;
                        break;
                    }
                }
            }
            if (left == prev_left && right == prev_right)
                break;
            prev_left = left;
            prev_right = right;
        }

        return maxArea;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int n = 15000;
        int[] height = new int[n];
        for (int i = 0; i < n; i++)
            height[i] = n - i;
        // int[] height = {2,3,4,5,18,17,6};
        int result = solution.maxArea(height);
        System.out.println("____________");
        System.out.println(result);
    }
}