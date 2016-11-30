/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        boolean switchA = false;
        boolean switchB = false;
        ListNode a = headA, b = headB;
        while (a != b){
            if (a.next == null && !switchA){
                a = headB;
                switchA = true;
            }
            else{
                a = a.next;
            }
            if (b.next == null && !switchB){
                b = headA;
                switchB = true;
            }
            else{
                b = b.next;
            }
        }
        return a;
    }
}