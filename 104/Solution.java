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
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        else{
            int dl = maxDepth(root.left);
            int dr = maxDepth(root.right);
            if (dl > dr)
                return dl + 1;
            else
                return dr + 1;
        }
    }
}