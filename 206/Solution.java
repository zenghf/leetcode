/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode a = head;
        ListNode b = a.next, c = null;
        a.next = null;
        do{
            c = b.next;
            System.out.println("" + a + b + c);
            b.next = a;
            a = b;
            b = c;
        }
        while(c != null);
        return a;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        ListNode node = new ListNode(new int[]{0, 1, 2});
        node.print();
        solution.reverseList(node).print();

    }
}