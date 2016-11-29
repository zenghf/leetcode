/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode even = head, oddHead = head.next, odd = oddHead;
        ListNode curr = odd.next;
        while(curr != null){
            even.next = curr;
            even = curr;
            curr = curr.next;
            if (curr == null)
                break;
            odd.next = curr;
            odd = curr;
            curr = curr.next;
        }
        odd.next = null;
        even.next = oddHead;
        return head;
    }


    public static void main(String[] args){
        Solution solution = new Solution();
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        solution.oddEvenList(head).print();
    }
}