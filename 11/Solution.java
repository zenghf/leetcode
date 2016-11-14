public class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        boolean right_limit = false;
        int right_end = n - 1;
        if (n < 2)
            return 0;
        int left = 0, right = n - 1;
        boolean left_small = true;
        int maxArea = 0;
        while (left < right){
            // System.out.println("left: " + left + " right: " + right);
            int most_left = left, most_right = right;
            if (left_small){
                int l = left;
                if (height[l] == 0){
                    left++;
                    continue;
                }
                for (int r = l + maxArea / height[l] + 1; r <= right; r++){
                    boolean temp_left_small = height[l] < height[r];
                    int area = (temp_left_small ? height[l] : height[r]) * (r - l);
                    if (area >= maxArea) {
                        left_small = temp_left_small;
                        maxArea = area;
                        most_right = r;
                    }
                }
            }
            else{
                int r = right;
                if (height[r] == 0){
                    right--;
                    continue;
                }
                for (int l = r - maxArea / height[r] - 1; l >= left; l--){
                    // System.out.println("left: " + left + " right: " + right + " l: " + l + " r: " + r);
                    boolean temp_left_small = height[l] < height[r];
                    int area = (temp_left_small ? height[l] : height[r]) * (r - l);
                    if (area >= maxArea) {
                        left_small = temp_left_small;
                        maxArea = area;
                        most_left = l;
                    }
                }
            }

            if (left_small){
                left++;
                if (most_right < right)
                    right = most_right;
            }
            else{
                right--;
                if (most_left > left)
                    left = most_left;
            }
        }

        // for (int left = 0; left < n - 1; left++){
        //     if (right_limit)
        //     if ((n - 1 - left) * height[left] < maxArea || height[left] == 0)
        //         continue;
        //     int right_start = left + maxArea / height[left] + 1;
        //     System.out.println("left: " + left + " right_start: " + right_end);
        //     for (int right = right_start; right < n; right++){
        //         int width = right - left;
        //         int h = height[left] < height[right] ? height[left] : height[right];
        //         int area = width * h;
        //         if (area > maxArea)
        //             maxArea = area;
        //     }
        // }
        return maxArea;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int n = 15000;
        int[] height = new int[n];
        for (int i = 0; i < n; i++)
            height[i] = n - i;
        // int[] height = {0,14,6,2,10,9,4,1,10,3};
        int result = solution.maxArea(height);
        System.out.println("____________");
        System.out.println(result);
    }
}