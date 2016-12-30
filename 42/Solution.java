public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length <= 2)
            return 0;
        int totalWater = 0;
        int left = 0;
        int right = height.length - 1;
        int h = height[0];
        for (int i = 1; i < height.length; i++){
            if (height[i] >= h){
                if (i - left >= 2){
                    int water = trap(height, left, i, h);
                    totalWater += water;
                }
                left = i;
                h = height[i];
            }
        }
        h = height[right];
        for (int i = height.length - 2; i >= left; i--){
            if (height[i] >= h){
                if (right - i >= 2){
                    int water = trap(height, i, right, h);
                    totalWater += water;
                }
                right = i;
                h = height[i];
            }
        }
        System.out.println(totalWater);
        return totalWater;
    }

    private int trap(int[] height, int left, int right, int h){
        int water = 0;
        // int h = Math.min(height[left], height[right]);
        for (int i = left + 1; i < right; i++)
            water += (h - height[i]);

        // System.out.println("left: " + left + " right: " + right + " h: " + h + " water: " + water);
        return water;
    }

    public static void main(String[] args){
        int[] height = {4,2,0,3,2,4,3,4};
        Solution solution = new Solution();
        solution.trap(height);
    }
}