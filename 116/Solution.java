/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

import java.util.LinkedList;

public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        LinkedList<LinkedList<TreeLinkNode>> nodesList = new LinkedList<>();
        LinkedList<TreeLinkNode> nodes = new LinkedList<>();
        nodes.add(root);
        nodesList.add(nodes);
        while(!nodesList.isEmpty()){
            int size = nodesList.size();
            for (int i = 0; i < size; i++){
                nodes = nodesList.pollFirst();
                TreeLinkNode prev = null;
                LinkedList<TreeLinkNode> children = new LinkedList<>();
                // System.out.println("first time new children");
                // System.out.println("nodes: " + nodes);
                for (TreeLinkNode node : nodes){
                    if (prev != null){
                        // System.out.println("prev: " + prev + " node: " + node);
                        prev.next = node;
                    }
                    prev = node;
                    TreeLinkNode[] leftRight = new TreeLinkNode[]{node.left, node.right};
                    for (TreeLinkNode child : leftRight){
                        if (child != null){
                            children.add(child);
                            // System.out.println("add " + child);
                        }
                        else{
                            if (!children.isEmpty()){
                                // System.out.println("new children");
                                nodesList.add(children);
                                children = new LinkedList<>();
                            }
                        }
                    }
                }
                if (!children.isEmpty())
                    nodesList.add(children);
            }
        }
    }


    public static void main(String[] args){
        Solution solution = new Solution();
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        solution.connect(root);
        TreeLinkNode[] nodes = new TreeLinkNode[] {root, root.left, root.right};
        for (TreeLinkNode node : nodes){
            System.out.println(node + " -> " + node.next);
        }
    }
}