import java.util.ArrayList;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int n = nums1.length, m = nums2.length;
        if (n == 0){
            if (m % 2 == 1)
                return nums2[m / 2];
            return (0.0 + nums2[m / 2] + nums2[m / 2 - 1]) / 2.0;
        }
        int half = (n + m) / 2;
        int low = 0, high = n;
        int mid = 0;
        int ind = 0;
        while (true){
            mid = (low + high) / 2;
            ind = half - mid;
            if (ind < m && mid > 0 && nums1[mid - 1] > nums2[ind]){
                high = mid - 1;
            }
            else if (mid < n && ind > 0 && nums2[ind - 1] > nums1[mid]){
                low = mid + 1;
            }
            else
                break;
        }

        System.out.println("mid: " + mid + " ind: " + ind + " n: " + n + " m: " + m);
        int right = 0;
        if (mid == n)
            right = nums2[ind];
        else if (ind == m)
            right = nums1[mid];
        else
            right = Math.min(nums1[mid], nums2[ind]);
        if ((n + m) % 2 ==1)
            return right;
        int left = 0;
        if (mid == 0)
            left = nums2[ind - 1];
        else if (ind == 0)
            left = nums1[mid - 1];
        else
            left = Math.max(nums1[mid - 1], nums2[ind - 1]);

        return (0.0 + left + right ) / 2.0;

    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums1 = {1};
        int[] nums2 = {2, 3};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }
}