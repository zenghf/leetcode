/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode root){
        if (root == null)
            return 0;
        int hL = height(root.left);
        if (hL == -1)
            return -1;
        int hR = height(root.right);
        if (hR == -1)
            return -1;
        if (Math.abs(hL - hR) > 1)
            return -1;
        return Math.max(hL, hR) + 1;
    }
}