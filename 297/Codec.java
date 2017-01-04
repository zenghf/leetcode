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
import java.util.Deque;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "[]";
        Deque<TreeNode> dq = new LinkedList<TreeNode>();
        LinkedList<String> words = new LinkedList<>();
        dq.add(root);
        while(!dq.isEmpty()){
            int size = dq.size();
            for (int i = 0; i < size; i++){
                TreeNode node = dq.removeFirst();
                if (node == null)
                    words.add("null");
                else{
                    words.add("" + node.val);
                    dq.add(node.left);
                    dq.add(node.right);
                }
            }
        }
        while(words.peekLast().equals("null"))
            words.removeLast();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (String word : words)
            sb.append(word + ",");
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]"))
            return null;
        String[] words = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(words[0]));
        Deque<TreeNode> dq = new LinkedList<TreeNode>();
        dq.add(root);
        int k = 1;
        boolean findEnd = false;
        while (!dq.isEmpty() && !findEnd){
            int size = dq.size();
            findEnd = false;
            for (int i = 0; i < size; i++){
                TreeNode node = dq.removeFirst();
                if (k >= words.length){
                    findEnd = true;
                    break;
                }
                TreeNode left = wordToTreeNode(words[k++]);
                node.left = left;
                if (k >= words.length){
                    findEnd = true;
                    break;
                }
                TreeNode right = wordToTreeNode(words[k++]);
                node.right = right;
                if (left != null)
                    dq.add(left);
                if (right != null)
                    dq.add(right);
            }
        }
        return root;
    }

    private TreeNode wordToTreeNode(String word){
        if (word.equals("null"))
            return null;
        return new TreeNode(Integer.parseInt(word));
    }

    public static void main(String[] args){
        Codec codec = new Codec();
        TreeNode root = codec.deserialize("[1,2]");
        System.out.println(root);
        System.out.println(root.left);
        System.out.println(root.right);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));