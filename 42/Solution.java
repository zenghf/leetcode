public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length <= 2)
            return 0;
        int water = 0;
        int left = 0;
        int right = height.length - 1;
        int hLeft = height[left];
        int hRight = height[right];
        while(left < right){
            if (hLeft <= hRight){
                int i = left + 1;
                while(height[i] < hLeft){
                    water += (hLeft - height[i]);
                    i++;
                }
                left = i;
                hLeft = height[left];
            }
            else{
                int i = right - 1;
                while(height[i] < hRight){
                    water += (hRight - height[i]);
                    i--;
                }
                right = i;
                hRight = height[right];
            }
        }
        System.out.println(water);
        return water;
    }

    public static void main(String[] args){
        int[] height = {4,2,0,3,2,4,3,4};
        Solution solution = new Solution();
        solution.trap(height);
    }
}