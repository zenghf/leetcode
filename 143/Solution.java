/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return;
        ListNode fast = head, slow = head, prev = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        ListNode h = slow;
        if (fast != null){
            h = slow.next;
            slow.next = null;
        }
        else
            prev.next = null;
        // System.out.println("middle: " + h);
        // h.print();
        // reverse h
        ListNode curr = h, front = null;
        prev = null;
        while(curr != null){
            front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;
        }
        h = prev;
        // System.out.print("head: "); head.print();
        // System.out.print("h: "); h.print();

        // inset h into head;
        curr = head;
        ListNode hFront = null;
        while(h != null){
            front = curr.next;
            hFront = h.next;
            curr.next = h;
            h.next = front;

            curr = front;
            h = hFront;
        }
        // head.print();
    }

    // public static void main(String[] args){
    //     Solution solution = new Solution();
    //     ListNode head = new ListNode(new int[] {1, 2, 3, 4, 5});
    //     solution.reorderList(head);
    // }
}