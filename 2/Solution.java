/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sol = new ListNode(0);
        ListNode s = sol;
        ListNode n1 = l1;
        ListNode n2 = l2;
        int a = 0;

        while (n1 != null || n2 != null || a == 1) {
            int v1 = 0;
            int v2 = 0;
            if (n1 != null)
                v1 = n1.val;
            if (n2 != null)
                v2 = n2.val;
            int v = a + v1 + v2;
            if (v >= 10) {
                v = v - 10;
                a = 1;
            }
            else
                a = 0;
            ListNode node = new ListNode(v);
            s.next = node;
            s = node;
            if (n1 != null)
                n1 = n1.next;
            if (n2 != null)
                n2 = n2.next;
        }
        return sol.next;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode("2->4->3->1");
        ListNode l2 = new ListNode("5->6->4");
        Solution sol = new Solution();
        ListNode res = sol.addTwoNumbers(l1, l2);
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(res);
    }
}