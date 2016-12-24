/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                break;
        }
        if (fast == null || fast.next == null)
            return null;
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(new int[] {1, 2, 3, 4, 5, 6, 7});
        ListNode curr = head;
        while(curr.next != null)
            curr = curr.next;
        curr.next = head.next.next;
        Solution solution = new Solution();
        ListNode cycle = solution.detectCycle(head);
        System.out.println(cycle.val);
    }
}