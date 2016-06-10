public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int m1 = n1 / 2;
        int m2 = n2 / 2;
    }

    public void printNums(String hint, int[] nums){
        System.out.print(hint);
        for (int i = 0; i < nums.length; i++){
            System.out.print(" " + nums[i])
        }
        System.out.println();
    }

    public static void main(String[] args){
        int[] nums1 = new int[]{1, 2, 3, 4};
        int[] nums2 = new int[]{3, 4, 5};
    }
}