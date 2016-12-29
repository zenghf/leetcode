/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayDeque<Boolean> pathP = new ArrayDeque<>();
        ArrayDeque<Boolean> pathQ = new ArrayDeque<>();
        findPath(root, p, pathP);
        findPath(root, q, pathQ);
        // System.out.println(pathP);
        // System.out.println(pathQ);
        TreeNode node = root;
        Iterator<Boolean> P = pathP.iterator();
        Iterator<Boolean> Q = pathQ.iterator();
        while(P.hasNext() && Q.hasNext()){
            boolean pp = P.next();
            boolean qq = Q.next();
            if (pp ^ qq)
                return node;
            if (pp)
                node = node.left;
            else
                node = node.right;
        }
        return node;
    }

    private boolean findPath(TreeNode root, TreeNode p, Deque<Boolean> path){
        if (root == null)
            return false;
        if (root == p)
            return true;

        path.addLast(true);
        if (findPath(root.left, p, path))
            return true;
        else
            path.removeLast();

        path.addLast(false);
        if (findPath(root.right, p, path))
            return true;
        else
            path.removeLast();

        return false;
    }
}