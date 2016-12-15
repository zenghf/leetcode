import java.util.Stack;
import java.util.Deque;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    TreeNode root;
    Stack<TreeNode> stack;
    Stack<Boolean> isLeft;
    TreeNode curr;
    boolean isFirstTime;

    public BSTIterator(TreeNode root) {
        this.root = root;
        this.stack = new Stack<>();
        this.isLeft = new Stack<>();
        TreeNode node = root, prev = root;
        while(node != null){
            this.stack.push(node);
            if (node == root)
                this.isLeft.push(false);
            else
                this.isLeft.push(true);
            prev = node;
            node = node.left;
        }
        this.curr = prev;
        this.isFirstTime = true;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (this.root == null)
            return false;
        if (this.isFirstTime)
            return true;
        if (this.curr.right != null)
            return true;
        for(Boolean b : this.isLeft){
            if (b)
                return true;
        }
        return false;
    }

    /** @return the next smallest number */
    public int next() {
        if (this.isFirstTime){
            this.isFirstTime = false;
            return this.curr.val;
        }
        if (this.curr.right != null){
            TreeNode node = this.curr.right;
            this.stack.push(node);
            this.isLeft.push(false);
            while(node.left != null){
                this.stack.push(node.left);
                this.isLeft.push(true);
                node = node.left;
            }
            this.curr = node;
            return this.curr.val;
        }
        while(true){
            boolean b = this.isLeft.pop();
            TreeNode node = this.stack.pop();
            if (b){
                this.curr = this.stack.peek();
                return this.curr.val;
            }
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */