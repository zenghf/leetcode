/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.LinkedList;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        int n = nums.length;
        LinkedList<Integer> inds = new LinkedList<>();
        LinkedList<TreeNode> nodes = new LinkedList<>();
        int mid = (0 + n) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        nodes.add(root);
        inds.add(0);
        inds.add(mid);
        inds.add(mid + 1);
        inds.add(n);
        while(!inds.isEmpty()){
            int n1 = inds.removeFirst();
            int n2 = inds.removeFirst();
            int n3 = inds.removeFirst();
            int n4 = inds.removeFirst();
            TreeNode node = nodes.removeFirst();

            if (n2 - n1 >= 1){
                int mid1 = (n1 + n2) / 2;
                node.left = new TreeNode(nums[mid1]);
                if (n2 - n1 > 1){
                    inds.add(n1);
                    inds.add(mid1);
                    inds.add(mid1 + 1);
                    inds.add(n2);
                    nodes.add(node.left);
                }
            }

            if (n4 - n3 >= 1){
                int mid2 = (n3 + n4) / 2;
                node.right = new TreeNode(nums[mid2]);
                if (n4 - n3 > 1){
                    inds.add(n3);
                    inds.add(mid2);
                    inds.add(mid2 + 1);
                    inds.add(n4);
                    nodes.add(node.right);
                }
            }
        }
        return root;
    }

}